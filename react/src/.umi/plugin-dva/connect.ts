// @ts-nocheck
import { IRoute } from '@umijs/core';
import { AnyAction } from 'redux';
import React from 'react';
import { EffectsCommandMap, SubscriptionAPI } from 'dva';
import { match } from 'react-router-dom';
import { Location, LocationState, History } from 'history';

export * from 'E:/start_react/react/src/models/global';
export * from 'E:/start_react/react/src/models/houseResource';
export * from 'E:/start_react/react/src/models/list';
export * from 'E:/start_react/react/src/models/login';
export * from 'E:/start_react/react/src/models/project';
export * from 'E:/start_react/react/src/models/setting';
export * from 'E:/start_react/react/src/models/user';
export * from 'E:/start_react/react/src/pages/Account/Settings/models/geographic';
export * from 'E:/start_react/react/src/pages/Dashboard/models/activities';
export * from 'E:/start_react/react/src/pages/Dashboard/models/chart';
export * from 'E:/start_react/react/src/pages/Dashboard/models/monitor';
export * from 'E:/start_react/react/src/pages/Exception/models/error';
export * from 'E:/start_react/react/src/pages/Forms/models/form';
export * from 'E:/start_react/react/src/pages/haoke/House/models/form';
export * from 'E:/start_react/react/src/pages/List/models/rule';
export * from 'E:/start_react/react/src/pages/Profile/models/profile';
export * from 'E:/start_react/react/src/pages/User/models/register';

export interface Action<T = any> {
  type: T
}

export type Reducer<S = any, A extends Action = AnyAction> = (
  state: S | undefined,
  action: A
) => S;

export type ImmerReducer<S = any, A extends Action = AnyAction> = (
  state: S,
  action: A
) => void;

export type Effect = (
  action: AnyAction,
  effects: EffectsCommandMap,
) => void;

/**
 * @type P: Type of payload
 * @type C: Type of callback
 */
export type Dispatch<P = any, C = (payload: P) => void> = (action: {
  type: string;
  payload?: P;
  callback?: C;
  [key: string]: any;
}) => any;

export type Subscription = (api: SubscriptionAPI, done: Function) => void | Function;

export interface Loading {
  global: boolean;
  effects: { [key: string]: boolean | undefined };
  models: {
    [key: string]: any;
  };
}

/**
 * @type P: Params matched in dynamic routing
 */
export interface ConnectProps<
  P extends { [K in keyof P]?: string } = {},
  S = LocationState,
  T = {}
> {
  dispatch?: Dispatch;
  // https://github.com/umijs/umi/pull/2194
  match?: match<P>;
  location: Location<S> & { query: T };
  history: History;
  route: IRoute;
}

export type RequiredConnectProps<
  P extends { [K in keyof P]?: string } = {},
  S = LocationState,
  T = {}
  > = Required<ConnectProps<P, S, T>>

/**
 * @type T: React props
 * @type U: match props types
 */
export type ConnectRC<
  T = {},
  U = {},
  S = {},
  Q = {}
> = React.ForwardRefRenderFunction<any, T & RequiredConnectProps<U, S, Q>>;

