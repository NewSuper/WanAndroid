// @ts-nocheck
import { Component } from 'react';
import { ApplyPluginsType } from 'umi';
import dva from 'dva';
// @ts-ignore
import createLoading from 'E:/start_react/react/node_modules/@umijs/plugin-dva/node_modules/dva-loading/dist/index.esm.js';
import { plugin, history } from '../core/umiExports';
import ModelGlobal0 from 'E:/start_react/react/src/models/global.js';
import ModelHouseResource1 from 'E:/start_react/react/src/models/houseResource.js';
import ModelList2 from 'E:/start_react/react/src/models/list.js';
import ModelLogin3 from 'E:/start_react/react/src/models/login.js';
import ModelProject4 from 'E:/start_react/react/src/models/project.js';
import ModelSetting5 from 'E:/start_react/react/src/models/setting.js';
import ModelUser6 from 'E:/start_react/react/src/models/user.js';
import ModelGeographic7 from 'E:/start_react/react/src/pages/Account/Settings/models/geographic.js';
import ModelActivities8 from 'E:/start_react/react/src/pages/Dashboard/models/activities.js';
import ModelChart9 from 'E:/start_react/react/src/pages/Dashboard/models/chart.js';
import ModelMonitor10 from 'E:/start_react/react/src/pages/Dashboard/models/monitor.js';
import ModelError11 from 'E:/start_react/react/src/pages/Exception/models/error.js';
import ModelForm12 from 'E:/start_react/react/src/pages/Forms/models/form.js';
import ModelForm13 from 'E:/start_react/react/src/pages/haoke/House/models/form.js';
import ModelRule14 from 'E:/start_react/react/src/pages/List/models/rule.js';
import ModelProfile15 from 'E:/start_react/react/src/pages/Profile/models/profile.js';
import ModelRegister16 from 'E:/start_react/react/src/pages/User/models/register.js';

let app:any = null;

export function _onCreate(options = {}) {
  const runtimeDva = plugin.applyPlugins({
    key: 'dva',
    type: ApplyPluginsType.modify,
    initialValue: {},
  });
  app = dva({
    history,
    
    ...(runtimeDva.config || {}),
    // @ts-ignore
    ...(typeof window !== 'undefined' && window.g_useSSR ? { initialState: window.g_initialProps } : {}),
    ...(options || {}),
  });
  
  app.use(createLoading());
  (runtimeDva.plugins || []).forEach((plugin:any) => {
    app.use(plugin);
  });
  app.model({ namespace: 'global', ...ModelGlobal0 });
app.model({ namespace: 'houseResource', ...ModelHouseResource1 });
app.model({ namespace: 'list', ...ModelList2 });
app.model({ namespace: 'login', ...ModelLogin3 });
app.model({ namespace: 'project', ...ModelProject4 });
app.model({ namespace: 'setting', ...ModelSetting5 });
app.model({ namespace: 'user', ...ModelUser6 });
app.model({ namespace: 'geographic', ...ModelGeographic7 });
app.model({ namespace: 'activities', ...ModelActivities8 });
app.model({ namespace: 'chart', ...ModelChart9 });
app.model({ namespace: 'monitor', ...ModelMonitor10 });
app.model({ namespace: 'error', ...ModelError11 });
app.model({ namespace: 'form', ...ModelForm12 });
app.model({ namespace: 'form', ...ModelForm13 });
app.model({ namespace: 'rule', ...ModelRule14 });
app.model({ namespace: 'profile', ...ModelProfile15 });
app.model({ namespace: 'register', ...ModelRegister16 });
  return app;
}

export function getApp() {
  return app;
}

/**
 * whether browser env
 * 
 * @returns boolean
 */
function isBrowser(): boolean {
  return typeof window !== 'undefined' &&
  typeof window.document !== 'undefined' &&
  typeof window.document.createElement !== 'undefined'
}

export class _DvaContainer extends Component {
  constructor(props: any) {
    super(props);
    // run only in client, avoid override server _onCreate()
    if (isBrowser()) {
      _onCreate()
    }
  }

  componentWillUnmount() {
    let app = getApp();
    app._models.forEach((model:any) => {
      app.unmodel(model.namespace);
    });
    app._models = [];
    try {
      // 释放 app，for gc
      // immer 场景 app 是 read-only 的，这里 try catch 一下
      app = null;
    } catch(e) {
      console.error(e);
    }
  }

  render() {
    let app = getApp();
    app.router(() => this.props.children);
    return app.start()();
  }
}
