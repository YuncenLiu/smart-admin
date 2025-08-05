/**
 * 计算表格自适应高度
 *
 * @param {*} heightRef
 * @param {*} removeRefArray
 * @param {*} extraRemoveHeight
 * @returns
 */

import { useAppConfigStore } from '../store/modules/system/app-config';

export function calcTableHeight(heightRef:any, removeRefArray:any, extraRemoveHeight:any) {
  let removeHeight = 0;
  if (removeRefArray && removeRefArray.length > 0) {
    for (const item of removeRefArray) {
      removeHeight = removeHeight + item.value.$el.offsetHeight;
    }
  }

  let due = 40;
  if (useAppConfigStore().$state.pageTagFlag) {
    due = due + 40;
  }
  if (useAppConfigStore().$state.footerFlag) {
    due = due + 40;
  }

  removeHeight = removeHeight + extraRemoveHeight + due;

  const layoutContent = document.querySelector('#smartAdminLayoutContent');
  if (layoutContent) {
    heightRef.value = (layoutContent as HTMLElement).offsetHeight - removeHeight;
  } else {
    heightRef.value = 0; // 或者设置一个默认高度
  }
}
