<!--
  * 数据库表信息
  *
  * @Author:    yun
  * @Date:      2025-08-04 16:02:55
  * @Copyright  liuyuncen.com
-->
<template>
  <a-modal
      :title="form.id ? '编辑' : '添加'"
      :width="200"
      :open="visibleFlag"
      @cancel="onClose"
      :maskClosable="false"
      :destroyOnClose="true"
  >
    <a-form ref="formRef" :model="form" :rules="rules" :label-col="{ span: 5 }" >
        <a-form-item label="表ID"  name="id">
          <a-input-number style="width: 100%" v-model:value="form.id" placeholder="表ID" />
        </a-form-item>
        <a-form-item label="数据库IP端口"  name="dbInfo">
          <a-input style="width: 100%" v-model:value="form.dbInfo" placeholder="数据库IP端口" />
        </a-form-item>
        <a-form-item label="数据库Schema"  name="dbSchema">
          <a-input style="width: 100%" v-model:value="form.dbSchema" placeholder="数据库Schema" />
        </a-form-item>
        <a-form-item label="数据库用户"  name="dbUser">
          <a-input style="width: 100%" v-model:value="form.dbUser" placeholder="数据库用户" />
        </a-form-item>
        <a-form-item label="表名"  name="tableName">
          <a-input style="width: 100%" v-model:value="form.tableName" placeholder="表名" />
        </a-form-item>
        <a-form-item label="数据条数"  name="allCount">
          <a-input-number style="width: 100%" v-model:value="form.allCount" placeholder="数据条数" />
        </a-form-item>
        <a-form-item label="删除数据"  name="deleteCount">
          <a-input-number style="width: 100%" v-model:value="form.deleteCount" placeholder="删除数据" />
        </a-form-item>
        <a-form-item label="创建人ID"  name="createUserId">
          <a-input-number style="width: 100%" v-model:value="form.createUserId" placeholder="创建人ID" />
        </a-form-item>
        <a-form-item label="创建人"  name="createUserName">
          <a-input style="width: 100%" v-model:value="form.createUserName" placeholder="创建人" />
        </a-form-item>
        <a-form-item label="创建时间"  name="createTime">
          <a-date-picker show-time valueFormat="YYYY-MM-DD HH:mm:ss" v-model:value="form.createTime" style="width: 100%" placeholder="创建时间" />
        </a-form-item>
        <a-form-item label="更新时间"  name="updateTime">
          <a-date-picker show-time valueFormat="YYYY-MM-DD HH:mm:ss" v-model:value="form.updateTime" style="width: 100%" placeholder="更新时间" />
        </a-form-item>
    </a-form>

    <template #footer>
      <a-space>
        <a-button @click="onClose">取消</a-button>
        <a-button type="primary" @click="onSubmit">保存</a-button>
      </a-space>
    </template>
  </a-modal>
</template>
<script setup>
  import { reactive, ref, nextTick } from 'vue';
  import _ from 'lodash';
  import { message } from 'ant-design-vue';
  import { SmartLoading } from '/@/components/framework/smart-loading';
  import { bCounApi } from '/src/api/business/b-coun/b-coun-api';
  import { smartSentry } from '/@/lib/smart-sentry';

  // ------------------------ 事件 ------------------------

  const emits = defineEmits(['reloadList']);

  // ------------------------ 显示与隐藏 ------------------------
  // 是否显示
  const visibleFlag = ref(false);

  function show(rowData) {
    Object.assign(form, formDefault);
    if (rowData && !_.isEmpty(rowData)) {
      Object.assign(form, rowData);
    }
    // 使用字典时把下面这注释修改成自己的字典字段 有多个字典字段就复制多份同理修改 不然打开表单时不显示字典初始值
    // if (form.status && form.status.length > 0) {
    //   form.status = form.status.map((e) => e.valueCode);
    // }
    visibleFlag.value = true;
    nextTick(() => {
      formRef.value.clearValidate();
    });
  }

  function onClose() {
    Object.assign(form, formDefault);
    visibleFlag.value = false;
  }

  // ------------------------ 表单 ------------------------

  // 组件ref
  const formRef = ref();

  const formDefault = {
      id: undefined, //表ID
      dbInfo: undefined, //数据库IP端口
      dbSchema: undefined, //数据库Schema
      dbUser: undefined, //数据库用户
      tableName: undefined, //表名
      allCount: undefined, //数据条数
      deleteCount: undefined, //删除数据
      createUserId: undefined, //创建人ID
      createUserName: undefined, //创建人
      createTime: undefined, //创建时间
      updateTime: undefined, //更新时间
  };

  let form = reactive({ ...formDefault });

  const rules = {
      id: [{ required: true, message: '表ID 必填' }],
      dbInfo: [{ required: true, message: '数据库IP端口 必填' }],
      dbSchema: [{ required: true, message: '数据库Schema 必填' }],
      dbUser: [{ required: true, message: '数据库用户 必填' }],
      tableName: [{ required: true, message: '表名 必填' }],
      allCount: [{ required: true, message: '数据条数 必填' }],
      deleteCount: [{ required: true, message: '删除数据 必填' }],
      createUserId: [{ required: true, message: '创建人ID 必填' }],
      createUserName: [{ required: true, message: '创建人 必填' }],
      createTime: [{ required: true, message: '创建时间 必填' }],
      updateTime: [{ required: true, message: '更新时间 必填' }],
  };

  // 点击确定，验证表单
  async function onSubmit() {
    try {
      await formRef.value.validateFields();
      save();
    } catch (err) {
      message.error('参数验证错误，请仔细填写表单数据!');
    }
  }

  // 新建、编辑API
  async function save() {
    SmartLoading.show();
    try {
      if (form.id) {
        await bCounApi.update(form);
      } else {
        await bCounApi.add(form);
      }
      message.success('操作成功');
      emits('reloadList');
      onClose();
    } catch (err) {
      smartSentry.captureError(err);
    } finally {
      SmartLoading.hide();
    }
  }

  defineExpose({
    show,
  });
</script>
