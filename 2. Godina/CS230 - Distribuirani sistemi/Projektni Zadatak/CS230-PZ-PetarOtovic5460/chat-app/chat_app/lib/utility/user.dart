import 'package:chat_app/utility/message.dart';

class User {
  String username;
  List<Message> messages;
  int unreadMessages = 0;

  User({required this.username, List<Message>? messages})
      : messages = messages ?? [];
}
