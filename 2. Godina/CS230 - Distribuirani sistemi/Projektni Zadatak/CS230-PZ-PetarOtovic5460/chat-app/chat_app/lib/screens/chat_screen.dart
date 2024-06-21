import 'package:chat_app/state/state.dart';
import 'package:chat_app/utility/server.dart';
import 'package:chat_app/utility/utils.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../utility/message.dart';

class ChatScreen extends StatefulWidget {
  const ChatScreen({super.key});

  @override
  State<ChatScreen> createState() => _ChatScreenState();
}

class _ChatScreenState extends State<ChatScreen> {
  late AppState appState;
  late Server server;
  late List<Message> messages;
  TextEditingController messageController = TextEditingController();
  final ScrollController _scrollController = ScrollController();
  List<Widget> chatMessages = [];

  @override
  void initState() {
    super.initState();
    print("Chat screen init");
    appState = Provider.of<AppState>(context, listen: false);
    server = appState.server!;
    messages = server.users[server.chatPartner]!.messages;
    appState.addListener(_handleStateChange);
    WidgetsBinding.instance!.addPostFrameCallback((timeStamp) {
      _scrollController.animateTo(
        _scrollController.position.maxScrollExtent,
        duration: Duration(milliseconds: 300),
        curve: Curves.easeOut,
      );
    });
  }

  void _handleStateChange() {
    print("Chat screen state change");
    if (server.chatPartner.isEmpty) {
      Navigator.of(context).pop();
      Utils.showSnackBar(context, "Chat partner went offline");
    }
    WidgetsBinding.instance!.addPostFrameCallback((timeStamp) {
      _scrollController.animateTo(
        _scrollController.position.maxScrollExtent,
        duration: Duration(milliseconds: 300),
        curve: Curves.easeOut,
      );
    });
  }

  @override
  void dispose() {
    appState.server!.chatPartner = "";
    appState.removeListener(_handleStateChange);
    appState.notifyListeners();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Chat with ${server.chatPartner}"),
        elevation: 0,
        leading: IconButton(
          onPressed: () {
            server.chatPartner = "";
            Navigator.of(context).pop();
          },
          icon: Icon(Icons.arrow_back),
        ),
      ),
      body: Column(
        children: [
          Expanded(
            child: messages.length == 0
                ? Center(
                    child: Text("No messages yet with ${server.chatPartner}"),
                  )
                : ListView.builder(
                    shrinkWrap: true,
                    controller: _scrollController,
                    itemCount: server.users[server.chatPartner] != null &&
                            server.users[server.chatPartner] != ""
                        ? server.users[server.chatPartner]!.messages.length
                        : 0,
                    itemBuilder: (context, index) {
                      String lastMessage = index == 0
                          ? ""
                          : server.users[server.chatPartner]!
                              .messages[index - 1].from;
                      return Padding(
                        padding: const EdgeInsets.only(
                            top: 2, bottom: 2, left: 8, right: 8),
                        child: Container(
                          child: Column(
                            crossAxisAlignment: server
                                        .users[server.chatPartner]!
                                        .messages[index]
                                        .from ==
                                    server.username
                                ? CrossAxisAlignment.end
                                : CrossAxisAlignment.start,
                            children: [
                              lastMessage == "" ||
                                      lastMessage !=
                                          server.users[server.chatPartner]!
                                              .messages[index].from
                                  ? Align(
                                      alignment: server
                                                  .users[server.chatPartner]!
                                                  .messages[index]
                                                  .from ==
                                              server.username
                                          ? Alignment.centerRight
                                          : Alignment.centerLeft,
                                      child: Container(
                                        padding: EdgeInsets.all(8),
                                        child: Text(
                                          server.users[server.chatPartner]!
                                              .messages[index].from,
                                          style: TextStyle(fontSize: 12),
                                        ),
                                      ),
                                    )
                                  : SizedBox.shrink(),
                              Align(
                                alignment: server.users[server.chatPartner]!
                                            .messages[index].from ==
                                        server.username
                                    ? Alignment.centerRight
                                    : Alignment.centerLeft,
                                child: ConstrainedBox(
                                  constraints: BoxConstraints(
                                    maxWidth:
                                        MediaQuery.of(context).size.width * 0.7,
                                  ),
                                  child: Container(
                                    decoration: BoxDecoration(
                                      color: server.users[server.chatPartner]!
                                                  .messages[index].from ==
                                              server.username
                                          ? Colors.blue.shade200
                                          : Colors.grey.shade200,
                                      borderRadius: BorderRadius.circular(30),
                                    ),
                                    padding: EdgeInsets.all(12),
                                    child: Text(
                                      server.users[server.chatPartner]!
                                          .messages[index].message,
                                    ),
                                  ),
                                ),
                              ),
                            ],
                          ),
                        ),
                      );
                    },
                  ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              children: [
                Expanded(
                  child: Container(
                    decoration: BoxDecoration(
                      color: Colors.grey.shade200,
                      borderRadius: BorderRadius.circular(30),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.only(left: 16),
                      child: TextField(
                        controller: messageController,
                        decoration: InputDecoration(
                          border: InputBorder.none,
                          hintText: "Type a message",
                        ),
                      ),
                    ),
                  ),
                ),
                IconButton(
                  onPressed: () {
                    server.sendChatMessage(messageController.text);
                    messageController.clear();
                    _scrollController.animateTo(
                      _scrollController.position.maxScrollExtent,
                      duration: Duration(milliseconds: 300),
                      curve: Curves.easeOut,
                    );
                  },
                  icon: Icon(Icons.send),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
