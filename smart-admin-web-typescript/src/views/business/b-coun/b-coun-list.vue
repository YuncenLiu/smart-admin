<!--
  * 数据库表信息
  *
  * @Author:    yun
  * @Date:      2025-08-04 16:02:55
  * @Copyright  liuyuncen.com
-->
<template>
  <!---------- 查询表单form begin ----------->
  <a-form class="smart-query-form">
    <a-row class="smart-query-form-row">
      <a-form-item label="表名" class="smart-query-form-item">
        <a-input style="width: 200px" v-model:value="queryForm.tableName" placeholder="表名(模糊查询)" />
      </a-form-item>
      <a-form-item label="表注释" class="smart-query-form-item">
        <a-input style="width: 200px" v-model:value="queryForm.tableDesc" placeholder="表注释(模糊查询)" />
      </a-form-item>
      <a-form-item label="库名" class="smart-query-form-item">
        <a-input style="width: 200px" v-model:value="queryForm.dbSchema" placeholder="数据库实例名称(精确查询)" />
      </a-form-item>
      <a-form-item class="smart-query-form-item">
        <a-button type="primary" @click="onSearch">
          <template #icon>
            <SearchOutlined />
          </template>
          查询
        </a-button>
        <a-button @click="resetQuery" class="smart-margin-left10">
          <template #icon>
            <ReloadOutlined />
          </template>
          重置
        </a-button>
        <a-button type="primary" class="smart-margin-left10" @click="loadData">
          <template #icon>
            <HomeOutlined />
          </template>
          生成
        </a-button>
      </a-form-item>
    </a-row>
  </a-form>
  <!---------- 查询表单form end ----------->

  <a-card size="small" :bordered="false" :hoverable="true">
    <!---------- 表格操作行 begin ----------->
    <a-row class="smart-table-btn-block">
      <div class="smart-table-operate-block">
      </div>
      <div class="smart-table-setting-block">
        <TableOperator v-model="columns" :tableId="null" :refresh="queryData" />
      </div>
    </a-row>
    <!---------- 表格操作行 end ----------->

    <!---------- 表格 begin ----------->
    <a-table
      size="small"
      :scroll="{ y: 800 }"
      :dataSource="tableData"
      :columns="columns"
      rowKey="id"
      bordered
      :loading="tableLoading"
      :pagination="false"
    >
      <template #bodyCell="{ text, record, column }">


        <template v-if="column.dataIndex === 'action'">
          <div class="smart-table-operate">
          </div>
        </template>
      </template>
    </a-table>
    <!---------- 表格 end ----------->

    <div class="smart-query-table-page">
      <a-pagination
        showSizeChanger
        showQuickJumper
        show-less-items
        :pageSizeOptions="PAGE_SIZE_OPTIONS"
        :defaultPageSize="queryForm.pageSize"
        v-model:current="queryForm.pageNum"
        v-model:pageSize="queryForm.pageSize"
        :total="total"
        @change="queryData"
        @showSizeChange="queryData"
        :show-total="(total) => `共${total}条`"
      />
    </div>

    <BCounForm ref="formRef" @reloadList="queryData" />

  </a-card>
</template>
<script setup>
import { reactive, ref, onMounted } from 'vue';
import { message, Modal } from 'ant-design-vue';
import { SmartLoading } from '/@/components/framework/smart-loading';
import { bCounApi } from '/src/api/business/b-coun/b-coun-api';
import { PAGE_SIZE_OPTIONS } from '/@/constants/common-const';
import { smartSentry } from '/@/lib/smart-sentry';
import TableOperator from '/@/components/support/table-operator/index.vue';
import BCounForm from './b-coun-form.vue';

// ---------------------------- 表格列 ----------------------------

const columns = ref([
  {
    title: 'IP端口',
    dataIndex: 'dbInfo',
    ellipsis: true,
  },
  {
    title: '库名',
    dataIndex: 'dbSchema',
    ellipsis: true,
  },
  {
    title: '用户',
    dataIndex: 'dbUser',
    ellipsis: true,
  },
  {
    title: '表名',
    dataIndex: 'tableName',
    ellipsis: true,
  },
  {
    title: '表注释',
    dataIndex: 'tableDesc',
    ellipsis: true,
  },
  {
    title: '条数',
    dataIndex: 'allCount',
    ellipsis: true,
  },
  {
    title: '删除条数',
    dataIndex: 'deleteCount',
    ellipsis: true,
  },
  {
    title: '创建时间',
    dataIndex: 'createTime',
    ellipsis: true,
    width: 180,
  },
  {
    title: '更新时间',
    dataIndex: 'updateTime',
    ellipsis: true,
    width: 180,
  },
]);

// ---------------------------- 查询数据表单和方法 ----------------------------

const queryFormState = {
  tableName: undefined, //tableName
  tableDesc: undefined, //tableDesc
  dbSchema: undefined, //数据库Schema
  pageNum: 1,
  pageSize: 10,
};
// 查询表单form
const queryForm = reactive({ ...queryFormState });
// 表格加载loading
const tableLoading = ref(false);
// 表格数据
const tableData = ref([]);
// 总数
const total = ref(0);

// 重置查询条件
function resetQuery() {
  let pageSize = queryForm.pageSize;
  Object.assign(queryForm, queryFormState);
  queryForm.pageSize = pageSize;
  queryData();
}

// 搜索
function onSearch() {
  queryForm.pageNum = 1;
  queryData();
}

function loadData() {
  postLoadData();
}

async function postLoadData(){
  try {
    let loadResult = await bCounApi.loadData();
    console.log(loadResult);
  }catch (e){
    smartSentry.captureError(e);
  }
}

// 查询数据
async function queryData() {
  tableLoading.value = true;
  try {
    let queryResult = await bCounApi.queryPage(queryForm);
    tableData.value = queryResult.data.list;
    total.value = queryResult.data.total;
  } catch (e) {
    smartSentry.captureError(e);
  } finally {
    tableLoading.value = false;
  }
}


onMounted(queryData);


</script>
