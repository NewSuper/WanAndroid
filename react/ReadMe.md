#### react 项目学习：

##### 1.使用idea 最新版本，没有new Javaweb选项，我们可以直接new project 即可

##### 2.新建完项目后，使用tyarn init -y 命令构建项目，会自动产生package.json配置文件（如没有tyarn 功能，可另外install 即可）

##### 3.此项目使用umi 构建,所以需要安装一些依赖，命令如下：

tyarn init -y

tyarn add umi --dev

umi dev    *运行成功后" (local:http:localhost:8000 ) 或者*  http://192.168.4.45:8000/Hello

tyarn add umi-plugin-react --dev

注意:运行此命令后，因新版  idea不兼容 ,

​            需要修改 package.json文件 “@umijs/preset-react": "^1"，

​            然后再修改config.js文件为dva:{}

```
export default {
    dva: {},
    antd: {}

//    plugins: [
//        ['umi-plugin-react',{
//          //暂时没有
//        }]
//    ]
};
--------------------------------------
{
  "name": "react",
  "version": "1.0.0",
  "main": "index.js",
  "license": "MIT",
  "devDependencies": {
    "umi": "^3.5.20",
    "@umijs/preset-react": "^1"
  }
}
```

umi build    构建打包使用，会自动生成dist目录

