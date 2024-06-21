import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Utils {
  static isValidIP(String ip) {
    List<String> parts = ip.split('.');
    if (parts.length != 4) {
      throw Exception('Invalid IP address');
    }
    List<String> port = parts[3].split(':');
    if (port.length > 2 || port.length < 2) {
      throw Exception('Invalid IP address');
    }
    if (int.parse(port[1]) < 0 || int.parse(port[1]) > 65535) {
      throw Exception('Invalid port number');
    }
  }

  static showSnackBar(BuildContext context, String message,
      {bool positive = false}) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        backgroundColor: positive ? Colors.green : Colors.red,
        content: Text(message),
        duration: const Duration(seconds: 2),
      ),
    );
  }

  static bool isAlphabetic(String input) {
    final alphabeticRegex = RegExp(r'^[a-zA-Z]+$');
    return alphabeticRegex.hasMatch(input);
  }
}
