import 'package:chat_app/screens/lobby_screen.dart';
import 'package:chat_app/utility/balancer.dart';
import 'package:chat_app/utility/utils.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../state/state.dart';
import '../utility/server.dart';

class HomeScreen extends StatefulWidget {
  HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  TextEditingController usernameController =
      TextEditingController(text: "Petar Otovic");
  TextEditingController serverIPController =
      TextEditingController(text: "192.168.0.107:12344");
  bool loading = false;
  late AppState state;

  void setLoader(bool value) {
    setState(() {
      loading = value;
    });
  }

  void connectToServer(BuildContext context) async {
    try {
      setLoader(true);
      if (usernameController.text.isEmpty ||
          usernameController.text.length < 3) {
        Utils.showSnackBar(
            context, "Username must be at least 3 characters long");
        setLoader(false);
        return;
      }

      if (serverIPController.text.isEmpty) {
        Utils.showSnackBar(context, "Please enter a server IP address.");
        setLoader(false);
        return;
      }

      Utils.isValidIP(serverIPController.text);

      List<String> balancerParts = serverIPController.text.split(":");

      Balancer balancer = Balancer(
        ip: balancerParts[0],
        port: int.parse(balancerParts[1]),
        onConnectionSuccess: onBalancerConnectionSuccess,
        onConnectionError: onConnectionError,
      );
    } catch (e) {
      Utils.showSnackBar(context, e.toString());
      setLoader(false);
    }
  }

  void onBalancerConnectionSuccess(String serverIP, List<int> serverPorts) {
    Server server = Server(
      username: usernameController.text,
      ip: serverIP,
      ports: serverPorts,
      onConnectionSuccess: onServerConnectionSuccess,
      onConnectionError: onConnectionError,
      notifyListeners: state.notify,
    );
  }

  void onServerConnectionSuccess(Server server) async {
    state.username = usernameController.text;
    state.server = server;
    Navigator.pushReplacement(
      context,
      MaterialPageRoute(
        builder: (context) => LobbyScreen(),
      ),
    );
  }

  void onConnectionError(String message) {
    Utils.showSnackBar(context, message);
    setLoader(false);
  }

  @override
  Widget build(BuildContext context) {
    state = Provider.of<AppState>(context, listen: false);

    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        title: const Text('CS230 Chat App'),
        elevation: 0,
      ),
      body: Column(
        children: [
          Expanded(
            child: Container(
              padding: const EdgeInsets.all(16),
              color: Colors.blue,
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const Text(
                      'Welcome to the chat app! Enter your username and server IP address to get started.',
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 14,
                      ),
                    ),
                    const Padding(
                      padding: EdgeInsets.only(top: 25),
                    ),
                    TextField(
                      style: const TextStyle(color: Colors.black),
                      controller: usernameController,
                      decoration: InputDecoration(
                        hintText: 'Username',
                        hintStyle: const TextStyle(color: Colors.grey),
                        filled: true,
                        fillColor: Colors.white,
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5),
                          borderSide: BorderSide.none,
                        ),
                        focusedBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5),
                          borderSide: BorderSide.none,
                        ),
                      ),
                    ),
                    const Padding(
                      padding: EdgeInsets.only(top: 10),
                    ),
                    TextField(
                      style: const TextStyle(color: Colors.black),
                      controller: serverIPController,
                      decoration: InputDecoration(
                        hintText: 'Server IP Address',
                        hintStyle: const TextStyle(color: Colors.black),
                        filled: true,
                        fillColor: Colors.white,
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5),
                          borderSide: BorderSide.none,
                        ),
                        focusedBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5),
                          borderSide: BorderSide.none,
                        ),
                      ),
                    ),
                    const Padding(
                      padding: EdgeInsets.only(top: 10),
                    ),
                    SizedBox(
                      width: double.infinity,
                      height: 40,
                      child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                          primary: Colors.redAccent,
                          onPrimary: Colors.red,
                          elevation: 0,
                        ),
                        onPressed: () {
                          connectToServer(context);
                        },
                        child: !loading
                            ? const Text('Connect',
                                style: TextStyle(
                                  color: Colors.black,
                                ))
                            : const SizedBox(
                                height: 10,
                                width: 10,
                                child: CircularProgressIndicator(),
                              ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
