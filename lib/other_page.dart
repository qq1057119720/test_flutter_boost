import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';

class OtherPage extends StatefulWidget {

  @override
  _SplashPageState createState() => _SplashPageState();
}

class _SplashPageState extends State<OtherPage> {

  @override
  void initState() {
    super.initState();
    Logger.log('boost-SplashPage $mounted');
  }

  @override
  Widget build(BuildContext context) {
    Logger.log('boost-SplashPage $mounted');
    return Scaffold(
      appBar: AppBar(
        title:  Text("Flutter 页面"),
      ),
      body: Flex(
        direction: Axis.vertical,
        children: [
          GestureDetector(
            onTap: (){
              BoostNavigator.instance.push("native");
            },
            child: Text(
              "这是另外的源生页面"
            ),
          )
        ],
      ),
    );
  }
}
