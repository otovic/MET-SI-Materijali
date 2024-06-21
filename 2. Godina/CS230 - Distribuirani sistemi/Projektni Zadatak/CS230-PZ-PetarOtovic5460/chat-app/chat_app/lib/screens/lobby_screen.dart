import 'package:chat_app/screens/home_screen.dart';
import 'package:chat_app/utility/utils.dart';
import 'package:chat_app/widgets/user_card.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter/src/widgets/placeholder.dart';
import 'package:provider/provider.dart';

import '../state/state.dart';
import '../utility/user.dart';
import 'chat_screen.dart';

class LobbyScreen extends StatefulWidget {
  LobbyScreen({super.key});
  @override
  State<LobbyScreen> createState() => _LobbyScreenState();
}

class _LobbyScreenState extends State<LobbyScreen> {
  late AppState appState;
  bool firstLoad = true;
  List<User> users = [];

  @override
  void initState() {
    super.initState();
    appState = Provider.of<AppState>(context, listen: false);
    appState.addListener(_handleStateChange);
  }

  void _handleStateChange() {
    if (appState.server == null) {
      Navigator.of(context).pushReplacement(
          MaterialPageRoute(builder: (context) => HomeScreen()));
    }
    print("Users: ${appState.server!.users}");
    if (appState.server!.users.length > 0) {
      setState(() {
        users = appState.server!.users.values.toList();
      });
    } else {
      setState(() {
        users = [];
      });
    }
    print(users[0].unreadMessages);
    setState(() {});
  }

  void endChat() {
    appState.removeListener(_handleStateChange);
    appState.server!.disconnect();
    Navigator.of(context)
        .pushReplacement(MaterialPageRoute(builder: (context) => HomeScreen()));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        title: Text(appState.username),
        elevation: 0,
      ),
      body: Container(
        padding: users.length == 0 ? EdgeInsets.all(16) : EdgeInsets.all(0),
        child: Column(
          children: [
            users.length == 0
                ? Expanded(
                    child: Center(
                      child: Text(
                        "There is no people available for chat at this time. Chat will refresh when someone is available.",
                        textAlign: TextAlign.center,
                      ),
                    ),
                  )
                : Expanded(
                    child: ListView.builder(
                      itemCount: appState.server!.users.length,
                      itemBuilder: (context, index) {
                        var user =
                            appState.server!.users.values.elementAt(index);
                        return UserCard(
                          username: user.username,
                          unreadMessages: user.unreadMessages,
                          onTap: () {
                            appState.server!.users[user.username]!
                                .unreadMessages = 0;
                            appState.notifyListeners();
                            appState.server!.chatPartner = user.username;
                            Navigator.of(context).push(MaterialPageRoute(
                                builder: (context) => ChatScreen()));
                          },
                        );
                      },
                    ),
                  ),
          ],
        ),
      ),
      bottomNavigationBar: BottomAppBar(
        elevation: 0,
        child: Container(
          padding: EdgeInsets.all(16),
          child: ElevatedButton(
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.red),
            ),
            onPressed: () {
              endChat();
            },
            child: Text("Exit Chat"),
          ),
        ),
      ),
    );
  }
}
