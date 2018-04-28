基于java反射机制的一款自动分析xls转为二进制pb文件的工具
pb是google提供的一套夸语言夸平台的高效内存小解析快的二进制数据流
xls是游戏开发中策划最得心应手的添数值和文案的工具
两者进行有效结合是开发游戏必备利器
可以应用在cocos2d和unity主流引擎中

如何生成更新项目pb文件：
下载安装protobuf-java-2.5.0
java版本：
cd 当前目录
protoc --java_out=./src ./*.proto
c++版本：
cd 当前目录
protoc --cpp_out=./ ./*.proto



如何运行项目：
工具需要装【eclipse】进行运行，暂时没有采用java包形式
main.java中进行修改配置输出选项

