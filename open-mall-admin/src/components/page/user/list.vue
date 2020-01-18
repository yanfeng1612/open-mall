<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i>菜单</el-breadcrumb-item>
                <el-breadcrumb-item>用户表管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                
                    <el-input v-model="searchData.query.id" placeholder="自动编号" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.username" placeholder="用户名" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.password" placeholder="密码" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.phone" placeholder="手机号" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.address" placeholder="地址" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.sex" placeholder="用户性别  0-未知   1-男  2-女" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.age" placeholder="用户年龄" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.birth" placeholder="生日" class="handle-input mr10"></el-input>
                 
                    <el-input v-model="searchData.query.email" placeholder="邮箱" class="handle-input mr10"></el-input>
                 
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
                
                    <el-table-column prop="username" label="用户名"   ></el-table-column>
                
                    <el-table-column prop="password" label="密码"   ></el-table-column>
                
                    <el-table-column prop="phone" label="手机号"   ></el-table-column>
                
                    <el-table-column prop="address" label="地址"   ></el-table-column>
                
                    <el-table-column prop="sex" label="用户性别  0-未知   1-男  2-女"   ></el-table-column>
                
                    <el-table-column prop="age" label="用户年龄"   ></el-table-column>
                
                    <el-table-column prop="birth" label="生日"   ></el-table-column>
                
                    <el-table-column prop="email" label="邮箱"   ></el-table-column>
                
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
                    "url": "/api/user/list?pageSize=" + self.pageInfo.pageSize + "&pageNo=" + self.pageInfo.curPage,
                    "data": this.searchData
                    , "callback": function (response) {
                        self.tableData = response.values;
                        self.pageInfo.curPage = response.pagenation.pageNo;
                        self.pageInfo.itemCount = response.pagenation.itemCount;
                    }
                });
            },
            toAdd() {
                this.$router.push({path: '/userEdit'});
            },
            toEdit(index, row) {
                const item = this.tableData[index];
                this.$router.push({path: '/userEdit', query: {id : item.id}, meta: {title: "edit"}});
            },
            toDetail(index, row) {
                const item = this.tableData[index];
                this.$router.push({path: '/userDetail', query: {id : item.id}, meta: {title: "edit"}});
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
