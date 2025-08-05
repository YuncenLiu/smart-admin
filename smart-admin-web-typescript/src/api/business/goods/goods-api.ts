/*
 * @Description:
 * @Author: zhuoda
 * @Date: 2021-11-05
 * @LastEditTime: 2022-06-23
 * @LastEditors: zhuoda
 */
import {postRequest, getRequest, getDownload} from '/@/lib/axios';

export const goodsApi = {
  // 添加商品 @author zhuoda
  addGoods: (param:any) => {
    return postRequest('/goods/add', param);
  },
  // 删除 @author zhuoda
  deleteGoods: (goodsId:any) => {
    return getRequest(`/goods/delete/${goodsId}`, {});
  },
  // 批量 @author zhuoda
  batchDelete: (goodsIdList:any) => {
    return postRequest('/goods/batchDelete', goodsIdList);
  },
  // 分页查询 @author zhuoda
  queryGoodsList: (param:any) => {
    return postRequest('/goods/query', param);
  },
  // 更新商品 @author zhuoda
  updateGoods: (param:any) => {
    return postRequest('/goods/update', param);
  },

  // 导入 @author 卓大
  importGoods : (file:any) =>{
    return postRequest('/goods/importGoods',file);
  },

  // 导出 @author 卓大
  exportGoods : () =>{
    return getDownload('/goods/exportGoods', {});
  }
};
