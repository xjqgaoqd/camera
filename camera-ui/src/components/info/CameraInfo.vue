<template>
    <div class="camera-info-container">
        <el-container class="camera-info">
            <el-header>
                <query-form @search="fetchData" />
            </el-header>
            <el-main>
                <product-list v-if="products.length" :products="products" />
                <el-empty v-else/>
            </el-main>
            <el-footer>
                <pagination :current-page="currentPage" :page-size="pageSize" :total-items="totalItems" @page-change="handlePageChange" />
            </el-footer>
        </el-container>
    </div>
  </template>
  
  <script>
  import QueryForm from './components/QueryForm.vue';
  import ProductList from './components/ProductList.vue';
  import Pagination from './components/Pagination.vue';

  import { fetchProducts } from '../../network/request';
  
  export default {
    components: {
      QueryForm,
      ProductList,
      Pagination,
    },
    data() {
        return {
            products: [],
            currentPage: 1,
            pageSize: 10,
            totalItems: 0, // 初始设置为0，待数据获取后更新
            filters: {
                pageIndex: 1,
                pageSize: 10,
                filter: {
                    issueMinPrice: 1000.0
                    // 其他筛选条件也可以在这里添加
                },
            },
        };
    },

    methods: {
    //   fetchProducts(query) {
    //     // 根据查询条件获取商品数据
    //     // 示例：使用假数据，实际需要从 API 获取数据
    //     this.products = [
    //       { id: 1, brand: '品牌A', model: '型号X', issueTime: '2023-08-01', content: '商品描述A', imageUrl: '1.jpg' },
    //       { id: 1, brand: '品牌A', model: '型号X', issueTime: '2023-08-01', content: '商品描述A', imageUrl: '2.webp' },
    //       { id: 1, brand: '品牌A', model: '型号X', issueTime: '2023-08-01', content: '商品描述A', imageUrl: 'image-url-a.jpg' },
          
    //       // 其他商品数据
    //     ];
    //   },
    async fetchData(query) {
    try {
      const res = await fetchProducts(1,10,{"issueMinPrice": 1000.0});

      // 将获取的数据设置到组件的data中
      this.products = res.data;
    } catch (error) {
      console.error('Error fetching data:', error);
      this.products = []; // 清空products以显示空状态
      this.totalItems = 0;
    }
     },
      handlePageChange(page) {
        // 处理分页切换
        this.currentPage = page;
        // 根据新页码获取数据
        this.fetchProducts(/* 使用当前查询条件和新页码获取数据 */);
      },
    },
  };
  </script>
  
  <style scoped>
  .camera-info {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
    box-sizing: border-box;
    width: 100%;
    max-width: 1200px;
    margin: 0 auto;
  }
  
  h1 {
    margin-bottom: 20px;
    text-align: center;
  }
  
  /* Query Form Style */
  .query-form {
    width: 100%;
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
  }
  
  /* Product List Style */
  .product-list {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  
  .product-item {
    width: calc(33.33% - 20px);
    margin-bottom: 20px;
    padding: 10px;
    border: 1px solid #ccc;
    display: flex;
    flex-direction: column;
  }
  
  .product-image {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .product-info {
    padding: 10px;
  }
  
  /* Pagination Style */
  .pagination {
    width: 100%;
    display: flex;
    justify-content: center;
  }
  </style>
  
  