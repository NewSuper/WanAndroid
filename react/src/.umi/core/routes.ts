// @ts-nocheck
import React from 'react';
import { ApplyPluginsType } from 'E:/start_react/react/node_modules/@umijs/runtime';
import * as umiExports from './umiExports';
import { plugin } from './plugin';

export function getRoutes() {
  const routes = [
  {
    "path": "/user",
    "component": require('E:/start_react/react/src/layouts/UserLayout').default,
    "routes": [
      {
        "path": "/user",
        "redirect": "/user/login",
        "exact": true
      },
      {
        "path": "/user/login",
        "component": require('E:/start_react/react/src/pages/User/Login').default,
        "exact": true
      },
      {
        "path": "/user/register",
        "component": require('E:/start_react/react/src/pages/User/Register').default,
        "exact": true
      },
      {
        "path": "/user/register-result",
        "component": require('E:/start_react/react/src/pages/User/RegisterResult').default,
        "exact": true
      }
    ]
  },
  {
    "path": "/",
    "component": require('E:/start_react/react/src/layouts/BasicLayout').default,
    "Routes": [
      "src/pages/Authorized"
    ],
    "authority": [
      "admin",
      "user"
    ],
    "routes": [
      {
        "path": "/",
        "redirect": "/house/resource",
        "exact": true
      },
      {
        "path": "/house",
        "name": "house",
        "icon": "home",
        "routes": [
          {
            "path": "/house/resource",
            "name": "resource",
            "component": require('E:/start_react/react/src/pages/haoke/House/Resource').default,
            "exact": true
          },
          {
            "path": "/house/addResource",
            "name": "addResource",
            "component": require('E:/start_react/react/src/pages/haoke/House/AddResource').default,
            "exact": true
          },
          {
            "path": "/house/kanfang",
            "name": "kanfang",
            "component": require('E:/start_react/react/src/pages/haoke/House/KanFang').default,
            "exact": true
          },
          {
            "path": "/house/zufang",
            "name": "zufang",
            "component": require('E:/start_react/react/src/pages/haoke/House/ZuFang').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/fangdong",
        "name": "fangdong",
        "icon": "key",
        "routes": [
          {
            "path": "/fangdong/list",
            "name": "list",
            "component": require('E:/start_react/react/src/pages/haoke/FangDong/List').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/users",
        "name": "users",
        "icon": "user",
        "routes": [
          {
            "path": "/users/list",
            "name": "list",
            "component": require('E:/start_react/react/src/pages/haoke/Users/List').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/heyue",
        "name": "heyue",
        "icon": "file-text",
        "routes": [
          {
            "path": "/heyue/list",
            "name": "list",
            "component": require('E:/start_react/react/src/pages/haoke/HeYue/List').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/news",
        "name": "news",
        "icon": "message",
        "routes": [
          {
            "path": "/news/list",
            "name": "list",
            "component": require('E:/start_react/react/src/pages/haoke/News/List').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/qa",
        "name": "qa",
        "icon": "question-circle",
        "routes": [
          {
            "path": "/news/list",
            "name": "list",
            "component": require('E:/start_react/react/src/pages/haoke/News/List').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/finance",
        "name": "finance",
        "icon": "money-collect",
        "routes": [
          {
            "path": "/finance/bill",
            "name": "bill",
            "component": require('E:/start_react/react/src/pages/haoke/Finance/Bill').default,
            "exact": true
          },
          {
            "path": "/finance/tixian",
            "name": "tixian",
            "component": require('E:/start_react/react/src/pages/haoke/Finance/TiXian').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/system",
        "name": "system",
        "icon": "laptop",
        "routes": [
          {
            "path": "/system/interface",
            "name": "interface",
            "component": require('E:/start_react/react/src/pages/haoke/System/Interface').default,
            "exact": true
          },
          {
            "path": "/system/dict",
            "name": "dict",
            "component": require('E:/start_react/react/src/pages/haoke/System/Dict').default,
            "exact": true
          },
          {
            "path": "/system/contract",
            "name": "contract",
            "component": require('E:/start_react/react/src/pages/haoke/System/Contract').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/dashboard",
        "redirect": "/dashboard/analysis",
        "exact": true
      },
      {
        "path": "/dashboard",
        "name": "dashboard",
        "icon": "dashboard",
        "hideChildrenInMenu": false,
        "routes": [
          {
            "path": "/dashboard/analysis",
            "name": "analysis",
            "component": require('E:/start_react/react/src/pages/Dashboard/Analysis').default,
            "exact": true
          },
          {
            "path": "/dashboard/monitor",
            "name": "monitor",
            "component": require('E:/start_react/react/src/pages/Dashboard/Monitor').default,
            "exact": true
          },
          {
            "path": "/dashboard/workplace",
            "name": "workplace",
            "component": require('E:/start_react/react/src/pages/Dashboard/Workplace').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/form",
        "icon": "form",
        "name": "form",
        "routes": [
          {
            "path": "/form/basic-form",
            "name": "basicform",
            "component": require('E:/start_react/react/src/pages/Forms/BasicForm').default,
            "exact": true
          },
          {
            "path": "/form/step-form",
            "name": "stepform",
            "component": require('E:/start_react/react/src/pages/Forms/StepForm').default,
            "hideChildrenInMenu": true,
            "routes": [
              {
                "path": "/form/step-form",
                "name": "stepform",
                "redirect": "/form/step-form/info",
                "exact": true
              },
              {
                "path": "/form/step-form/info",
                "name": "info",
                "component": require('E:/start_react/react/src/pages/Forms/StepForm/Step1').default,
                "exact": true
              },
              {
                "path": "/form/step-form/confirm",
                "name": "confirm",
                "component": require('E:/start_react/react/src/pages/Forms/StepForm/Step2').default,
                "exact": true
              },
              {
                "path": "/form/step-form/result",
                "name": "result",
                "component": require('E:/start_react/react/src/pages/Forms/StepForm/Step3').default,
                "exact": true
              }
            ]
          },
          {
            "path": "/form/advanced-form",
            "name": "advancedform",
            "authority": [
              "admin"
            ],
            "component": require('E:/start_react/react/src/pages/Forms/AdvancedForm').default,
            "exact": true
          }
        ]
      },
      {
        "path": "/list",
        "icon": "table",
        "name": "list",
        "routes": [
          {
            "path": "/list/table-list",
            "name": "searchtable",
            "component": require('E:/start_react/react/src/pages/List/TableList').default,
            "exact": true
          },
          {
            "path": "/list/basic-list",
            "name": "basiclist",
            "component": require('E:/start_react/react/src/pages/List/BasicList').default,
            "exact": true
          },
          {
            "path": "/list/card-list",
            "name": "cardlist",
            "component": require('E:/start_react/react/src/pages/List/CardList').default,
            "exact": true
          },
          {
            "path": "/list/search",
            "name": "searchlist",
            "component": require('E:/start_react/react/src/pages/List/List').default,
            "routes": [
              {
                "path": "/list/search",
                "redirect": "/list/search/articles",
                "exact": true
              },
              {
                "path": "/list/search/articles",
                "name": "articles",
                "component": require('E:/start_react/react/src/pages/List/Articles').default,
                "exact": true
              },
              {
                "path": "/list/search/projects",
                "name": "projects",
                "component": require('E:/start_react/react/src/pages/List/Projects').default,
                "exact": true
              },
              {
                "path": "/list/search/applications",
                "name": "applications",
                "component": require('E:/start_react/react/src/pages/List/Applications').default,
                "exact": true
              }
            ]
          }
        ]
      },
      {
        "path": "/profile",
        "name": "profile",
        "icon": "profile",
        "routes": [
          {
            "path": "/profile/basic",
            "name": "basic",
            "component": require('E:/start_react/react/src/pages/Profile/BasicProfile').default,
            "exact": true
          },
          {
            "path": "/profile/advanced",
            "name": "advanced",
            "authority": [
              "admin"
            ],
            "component": require('E:/start_react/react/src/pages/Profile/AdvancedProfile').default,
            "exact": true
          }
        ]
      },
      {
        "name": "result",
        "icon": "check-circle-o",
        "path": "/result",
        "routes": [
          {
            "path": "/result/success",
            "name": "success",
            "component": require('E:/start_react/react/src/pages/Result/Success').default,
            "exact": true
          },
          {
            "path": "/result/fail",
            "name": "fail",
            "component": require('E:/start_react/react/src/pages/Result/Error').default,
            "exact": true
          }
        ]
      },
      {
        "name": "exception",
        "icon": "warning",
        "path": "/exception",
        "routes": [
          {
            "path": "/exception/403",
            "name": "not-permission",
            "component": require('E:/start_react/react/src/pages/Exception/403').default,
            "exact": true
          },
          {
            "path": "/exception/404",
            "name": "not-find",
            "component": require('E:/start_react/react/src/pages/Exception/404').default,
            "exact": true
          },
          {
            "path": "/exception/500",
            "name": "server-error",
            "component": require('E:/start_react/react/src/pages/Exception/500').default,
            "exact": true
          },
          {
            "path": "/exception/trigger",
            "name": "trigger",
            "hideInMenu": true,
            "component": require('E:/start_react/react/src/pages/Exception/TriggerException').default,
            "exact": true
          }
        ]
      },
      {
        "name": "account",
        "icon": "user",
        "path": "/account",
        "routes": [
          {
            "path": "/account/center",
            "name": "center",
            "component": require('E:/start_react/react/src/pages/Account/Center/Center').default,
            "routes": [
              {
                "path": "/account/center",
                "redirect": "/account/center/articles",
                "exact": true
              },
              {
                "path": "/account/center/articles",
                "component": require('E:/start_react/react/src/pages/Account/Center/Articles').default,
                "exact": true
              },
              {
                "path": "/account/center/applications",
                "component": require('E:/start_react/react/src/pages/Account/Center/Applications').default,
                "exact": true
              },
              {
                "path": "/account/center/projects",
                "component": require('E:/start_react/react/src/pages/Account/Center/Projects').default,
                "exact": true
              }
            ]
          },
          {
            "path": "/account/settings",
            "name": "settings",
            "component": require('E:/start_react/react/src/pages/Account/Settings/Info').default,
            "routes": [
              {
                "path": "/account/settings",
                "redirect": "/account/settings/base",
                "exact": true
              },
              {
                "path": "/account/settings/base",
                "component": require('E:/start_react/react/src/pages/Account/Settings/BaseView').default,
                "exact": true
              },
              {
                "path": "/account/settings/security",
                "component": require('E:/start_react/react/src/pages/Account/Settings/SecurityView').default,
                "exact": true
              },
              {
                "path": "/account/settings/binding",
                "component": require('E:/start_react/react/src/pages/Account/Settings/BindingView').default,
                "exact": true
              },
              {
                "path": "/account/settings/notification",
                "component": require('E:/start_react/react/src/pages/Account/Settings/NotificationView').default,
                "exact": true
              }
            ]
          }
        ]
      },
      {
        "component": require('E:/start_react/react/src/pages/404').default,
        "exact": true
      }
    ]
  }
];

  // allow user to extend routes
  plugin.applyPlugins({
    key: 'patchRoutes',
    type: ApplyPluginsType.event,
    args: { routes },
  });

  return routes;
}
