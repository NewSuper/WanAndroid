import os import 'os';
import pageRoutes from './router.config';
import webpackPlugin from './plugin.config';
import defaultSetting from '../src/defaultSettings';

export default {
  plugins: [
    ['umi-plugin-react',
    {
      antd: true,
      dva: {
        hmr: true,
      },
      targets :{
        ie: 11,
      },
      locale: {
        enable: true,
        default: 'zh-CN',
        baseNavigator: true,
      },
      dynamicImport: {
        loadingComponent: './components/PageLoading/index',
      },
      ...(!process.env.TEST && os.platform() === 'darwin' ? {
        dll: {
          include: ['dva','dva/router','dva/saga','dva/fetch'],
          exclude: ['@babel/runtime'],
        },
        hardSource: true,
      }: {}),
    }],
    [
    'umi-plugin-ga',
    {
      code : 'UA-72788897-6',
      judgeL () => process.env.APP_TYPE === 'site',
    },
    ],
  ],
  targets: {
    ie: 11,
  },
  define: {
     APP_TYPE : process.env.APP_TYPE || '',
  },
  routes: pageRoutes,
  theme: {
    'primary-color': defaultSettings.primaryColor,
  },
  proxy: {
    '/haoke': {
      target: 'http://127.0.0.1:18080',
      changeOrigin: true,
      pathRewrite: { '^/haoke/': ''}
    }
  },
  externals : {
    '@antv/data-set':'DataSet',
  },
  ignoreMomentLocale: true,
  lessLoaderOptions: {
    javascriptEnabled: true,
  },
  disableRedirectHoist: true,
  cssLoaderOptions: {
    modules: true,
    getLocalIdent: (context,localIdentName,localName) =>{
      if(context .resourcePath.includes('node_modules') ||
        context .resourcePath.includes('ant.design.pro.less') ||
        context.resourcePath.includes('global.less')){
      return localName;
      }
      const match = context.resourcePath.match(/src(.*)/);
      if(match && match[1]){
        const antdProPath = match[1].replace('.less','');
        const arr = antdProPath
           .split('/')
           .map(a => a.replace(/([A-Z])/g, '-$1'))
           .map(a => a.toLowerCase());
        return `antd-pro${arr.join('-')}-${localName}`.replace(/--/g, '-');
      }
      return localName;
    },
  },
  manifest: {
    name: 'ant-design-pro',
    background_color: '#FFF',
    description: 'An out-of-box UI solution for enterprise applications as a React boilerplate.',
    display: 'standalone',
    start_url: '/index.html',
    icons: [
      {
        src: '/favicon.png',
        sizes: '48x48',
        type: 'image/png',
      },
    ],
  },

  chainWebpack: webpackPlugin,
  cssnano: {
    mergeRules: false,
  },

};