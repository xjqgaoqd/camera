<template>
    <div class="query-form">
      <!-- 品牌下拉框 -->
      <el-select v-model="brand" placeholder="品牌">
        <el-option v-for="brandOption in brandOptions" :key="brandOption" :value="brandOption" :label="brandOption" />
      </el-select>
      <el-select v-model="brand" placeholder="品牌">
        <el-option v-for="brandOption in brandOptions" :key="brandOption" :value="brandOption" :label="brandOption" />
      </el-select>
      <el-select v-model="brand" placeholder="品牌">
        <el-option v-for="brandOption in brandOptions" :key="brandOption" :value="brandOption" :label="brandOption" />
      </el-select>
      <el-select v-model="brand" placeholder="品牌">
        <el-option v-for="brandOption in brandOptions" :key="brandOption" :value="brandOption" :label="brandOption" />
      </el-select>
      <!-- 其他查询条件 -->
      <!-- ... -->
      <el-button @click="search" type="primary" round>查询</el-button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        brand: '',
        brandOptions: ['品牌A', '品牌B', '品牌C'], // 替换为实际的品牌选项
        // 其他查询条件的数据
        
      };
    },
    methods: {
      search() {
        // 执行查询操作
        this.$emit('search', {});
      },
    },
  };
  </script>
  
  <style scoped>
  .query-form {
    margin-bottom: 20px;
  }
  </style>
  