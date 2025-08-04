/**
 * 数据库表信息 api 封装
 *
 * @Author:    yun
 * @Date:      2025-08-04 16:02:55
 * @Copyright  liuyuncen.com
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const bCounApi = {

  /**
   * 分页查询  @author  yun
   */
  queryPage : (param) => {
    return postRequest('/bCoun/queryPage', param);
  },

  /**
   * 加载数据  @author  yun
   */
  loadData: () =>{
    return postRequest('/bCoun/loadData')
  },
};
