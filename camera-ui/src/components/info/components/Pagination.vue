<template>
    <div class="pagination">
      <!-- 分页组件 -->
      <el-pagination
        background
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pageSize"
        :total="totalItems"
        layout="prev, pager, next"
      />
    </div>
  </template>
  
  <script>
  export default {
    props: {
      currentPage: Number, // 当前页码
      pageSize: Number, // 每页显示数量
      totalItems: Number, // 总数据条数
    },
    methods: {
      handleCurrentChange(page) {
        // 处理分页切换
        this.$emit('page-change', page);
      },
    },
  };
  </script>
  
  <style scoped>
  /* .pagination {
    margin-top: 20px;
    display: flex;
    justify-content: center;
  } */
  </style>
  