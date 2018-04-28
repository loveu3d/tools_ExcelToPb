如何生成更新项目pb文件：
下载安装protobuf-java-2.5.0
java版本：
cd 当前目录
protoc --java_out=./src ./*.proto
c++版本：
cd 当前目录
protoc --cpp_out=./ ./*.proto

如何运行项目：
eclipse直接导入项目文件夹
运行即可输出pb二进制文件
