<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i>菜单</el-breadcrumb-item>
                <el-breadcrumb-item>订单明细表管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                
                    <el-input v-model="searchData.query.id" placeholder="自动编号" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.orderKey" placeholder="order_key" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.userId" placeholder="用户id" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.userName" placeholder="用户名称" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.sex" placeholder="用户性别  0-未知   1-男  2-女" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.phone" placeholder="手机号" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.productId" placeholder="商品id" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.productName" placeholder="商品名称" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.unit" placeholder="商品单位" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.categroyId" placeholder="商品分类id" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.categroyName" placeholder="商品分类名称" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.brandId" placeholder="商品品牌id" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.brandName" placeholder="商品品牌名称" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.price" placeholder="售价" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.productCount" placeholder="已点数量" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.totalAmount" placeholder="总价" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.remark" placeholder="备注" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.yn" placeholder="数据状态 0-无效 1-有效" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.createdTime" placeholder="创建时间" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.modifiedTime" placeholder="修改时间" class="handle-input mr10"></el-input>
                 
                <el-button type="primary" icon="search" @click="search">搜 索</el-button>
            </div>
            <div class="handle-box">
                <el-button type="primary" icon="search" @click="toAdd">新 增</el-button>
            </div>
            <el-table :data="tableData" border style="width: 100%" ref="multipleTable" @selection-change="handleSelectionChange">
                
                    <el-table-column prop="id" label="自动编号"   ></el-table-column>
                
                    <el-table-column prop="orderKey" label="order_key"   ></el-table-column>
                
                    <el-table-column prop="userId" label="用户id"   ></el-table-column>
                
                    <el-table-column prop="userName" label="用户名称"   ></el-table-column>
                
                    <el-table-column prop="sex" label="用户性别  0-未知   1-男  2-女"   ></el-table-column>
                
                    <el-table-column prop="phone" label="手机号"   ></el-table-column>
                
                    <el-table-column prop="productId" label="商品id"   ></el-table-column>
                
                    <el-table-column prop="productName" label="商品名称"   ></el-table-column>
                
                    <el-table-column prop="unit" label="商品单位"   ></el-table-column>
                
                    <el-table-column prop="categroyId" label="商品分类id"   ></el-table-column>
                
                    <el-table-column prop="categroyName" label="商品分类名称"   ></el-table-column>
                
                    <el-table-column prop="brandId" label="商品品牌id"   ></el-table-column>
                
                    <el-table-column prop="brandName" label="商品品牌名称"   ></el-table-column>
                
                    <el-table-column prop="price" label="售价"   ></el-table-column>
                
                    <el-table-column prop="productCount" label="已点数量"   ></el-table-column>
                
                    <el-table-column prop="totalAmount" label="总价"   ></el-table-column>
                
                    <el-table-column prop="remark" label="备注"   ></el-table-column>
                
                    <el-table-column prop="yn" label="数据状态 0-无效 1-有效"   ></el-table-column>
                
                    <el-table-column prop="createdTime" label="创建时间"   ></el-table-column>
                
                    <el-table-column prop="modifiedTime" label="修改时间"   ></el-table-column>
                
                <el-table-column label="操作" width="180">
                    <template slot-scope="scope">
                        <el-button size="small" @click="toEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="small" @click="toDetail(scope.$index, scope.row)" >查询详情</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination ref="tabPagination" @current-change="handleCurrentChange" @size-change="handleSizeChange"
                               layout="total, sizes, prev, pager, next, jumper" :current-page.sync="pageInfo.curPage"
                               :page-size="pageInfo.pageSize"
                               :total="pageInfo.itemCount">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
    import {requestData} from "../../../utils/request";

    export default {
        name: 'basetable',
        data() {
            return {
                searchData: {query : {yn: "1"}},
                tableData: [],
                pageInfo: {curPage: 1, pageNo: 1, pageSize: 10, itemCount: 1}
            }
        },
        created() {
            this.getData();
        },
        computed: {
            data() {
                return this.tableData;
            }
        },
        methods: {
            handleCurrentChange(val) {
                this.pageInfo.curPage = val;
                this.getData();
            },
            handleSizeChange(val) {
                this.pageInfo.pageSize = val;
                this.getData();
            },
            getData() {
                let self = this;
                let sData = this.searchData;
                sData["pageSize"] = this.pageInfo.pageSize;
                sData["pageNo"] = this.pageInfo.curPage;
                requestData({
                    "url": "/api/orderDetail/list?pageSize=" + self.pageInfo.pageSize + "&pageNo=" + self.pageInfo.curPage,
                    "data": this.searchData
                    , "callback": function (response) {
                        self.tableData = response.values;
                        self.pageInfo.curPage = response.pagenation.pageNo;
                        self.pageInfo.itemCount = response.pagenation.itemCount;
                    }
                });
            },
            toAdd() {
                this.$router.push({path: '/orderDetailEdit'});
            },
            toEdit(index, row) {
                const item = this.tableData[index];
                this.$router.push({path: '/orderDetailEdit', query: {id : item.id}, meta: {title: "edit"}});
            },
            toDetail(index, row) {
                const item = this.tableData[index];
                this.$router.push({path: '/orderDetailDetail', query: {id : item.id}, meta: {title: "edit"}});
            },
            search() {
                this.$refs.tabPagination.lastEmittedPage = 1;
                this.pageInfo = {curPage: 1, pageNo: 1, pageSize: 10, itemCount: 1};
                this.getData();
            },
            
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
        }
    }
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 200px;
        display: inline-block;
    }

    .del-dialog-cnt {
        font-size: 16px;
        text-align: center
    }
</style>
