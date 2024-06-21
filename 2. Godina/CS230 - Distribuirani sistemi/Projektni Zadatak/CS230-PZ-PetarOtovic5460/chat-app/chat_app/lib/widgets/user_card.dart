import 'package:flutter/material.dart';

class UserCard extends StatefulWidget {
  UserCard(
      {super.key,
      required this.username,
      required this.onTap,
      this.unreadMessages = 0});
  final String username;
  Function? onTap;
  int unreadMessages = 0;

  @override
  State<UserCard> createState() => _UserCardState();
}

class _UserCardState extends State<UserCard> {
  @override
  Widget build(BuildContext context) {
    return Material(
      color: Colors.transparent,
      child: InkWell(
        onTap: () {
          widget.onTap!();
        },
        splashColor: Colors.grey.withOpacity(0.5),
        highlightColor: Colors.grey.withOpacity(0.5),
        child: Container(
          height: 60,
          decoration: BoxDecoration(
            border: Border(
              bottom: BorderSide(color: Colors.grey.shade300),
            ),
          ),
          child: Padding(
            padding: const EdgeInsets.only(left: 16),
            child: Row(
              children: [
                Expanded(
                  flex: 10,
                  child: Text(widget.username,
                      style: const TextStyle(fontSize: 18)),
                ),
                Expanded(
                  flex: 1,
                  child: widget.unreadMessages > 0
                      ? Container(
                          height: 20,
                          width: 20,
                          decoration: BoxDecoration(
                            color: Colors.red,
                            borderRadius: BorderRadius.circular(10),
                          ),
                          child: Center(
                            child: Text(
                              widget.unreadMessages.toString(),
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 12,
                              ),
                            ),
                          ),
                        )
                      : SizedBox.shrink(),
                ),
                Expanded(
                  flex: 1,
                  child: Icon(Icons.arrow_forward_ios, size: 16),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
