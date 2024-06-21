import 'dart:convert';
import 'dart:io';

import 'package:chat_app/utility/utils.dart';

class Balancer {
  late String ip;
  late int port;
  late Function onConnectionSuccess;
  late Function onConnectionError;

  Balancer({
    required this.ip,
    required this.port,
    required this.onConnectionSuccess,
    required this.onConnectionError,
  }) {
    _connect();
  }

  void _connect() async {
    try {
      var balancer = await Socket.connect(ip, port);
      print(
          'Connected to: ${balancer.remoteAddress.address}:${balancer.remotePort}');

      balancer.listen((data) {
        String message = utf8.decoder.convert(data);
        print('Received from balancer: $message');
        _parseMessage(message);
      }, onDone: () {
        print('Balancer closed');
        balancer.destroy();
      });

      balancer.write('rq//request_connection\n');
    } catch (e) {
      print('Unable to connect to balancer: $e');
      onConnectionError("Unable to connect to balancer");
    }
  }

  void _parseMessage(String message) {
    if (message.startsWith("rs//request_connection_error:no_servers")) {
      onConnectionError("No servers available");
      return;
    }
    if (message.startsWith("rs//request_connection_success")) {
      List<String> parts = message.split(":");
      onConnectionSuccess(
        parts[1],
        [
          int.parse(parts[2]),
          int.parse(parts[3]),
          int.parse(parts[4]),
        ],
      );
      return;
    }
  }
}
