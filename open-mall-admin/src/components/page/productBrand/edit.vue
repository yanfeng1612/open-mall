<template>
    <el-form :rules="rules" :model="formData" ref="formData" label-width="160px" class="demo-ruleForm">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i> 商品品牌表</el-breadcrumb-item>
                <el-breadcrumb-item>编辑商品品牌表</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container container-margin">
            <el-input v-model="formData.id" type="hidden" />

            <el-row>
                <el-col :span="8">
                    <el-form-item label="自动编号：" prop="自动编号">
                        <el-input v-model="formData.id" placeholder="id"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品品牌名称：" prop="商品品牌名称">
                        <el-input v-model="formData.brandName" placeholder="brandName"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="分类描述：" prop="分类描述">
                        <el-input v-model="formData.description" placeholder="description"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="排序：" prop="排序">
                        <el-input v-model="formData.rank" placeholder="rank"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="数据状态 0-无效 1-有效：" prop="数据状态 0-无效 1-有效">
                        <el-input v-model="formData.yn" placeholder="yn"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="创建时间：" prop="创建时间">
                        <el-input v-model="formData.createdTime" placeholder="createdTime"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="修改时间：" prop="修改时间">
                        <el-input v-model="formData.modifiedTime" placeholder="modifiedTime"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

        </div>
        <div class="container-margin to-center ">
            <el-button type="primary" @click="toSave">保 存</el-button>
            <el-button type="primary" @click="toCancel">取 消</el-button>
        </div>
    </el-form>
</template>

<script>
    import {requestData} from "../../../utils/request";

    export default {
        name: 'baseform',
        data: function () {
            return {
                selectItem: null,
                loginUserType:localStorage.getItem('userType'),
                loginCompanyNo:localStorage.getItem('companyNo'),
                enable :false,
                oldData: null,
                isInactive: false,
                formData: {},
                rules: {}
            }
        },
        created() {
            this.getData();
        },
        methods: {
            getData() {
                var self = this;
                if (this.$route.query.id != null) {
                    requestData({
                        "url": "/api/productBrand/detail",
                        "data": {id: this.$route.query.id},
                        "callback": function (redata) {
                            self.formData = redata;
                        }
                    });
                }
            },
            toSave() {
                var self = this;

                this.$refs["formData"].validate((valid) => {
                    if (valid) {
                        requestData({
                            "url": "/api/productBrand/updateById",
                            "data": this.formData
                            , "callback": function (redata) {
                                self.$message({
                                    type: 'success',
                                    message: '保存成功!'
                                });
                                self.$router.push({path: '/productBrandList'});
                            }
                        });

                    }
                });
            },
            toCancel() {
                this.$router.push({path: '/productBrandList'});
            },
            onSubmit: function () {
                var isValid = false;
                this.$refs["formData"].validate((valid) => {
                    if (valid) {
                        isValid = true;
                    } else {
                        isValid = false;
                    }
            });
                return isValid;
            }
        }
    }
</script>
<style>
    .container-margin {
        margin-top: 10px;
    }

    .bold {
        font-weight: bold;
        color: #606266;
    }

    .to-right {
        text-align: right;
    }

    .to-center {
        text-align: center;
    }

    .el-row {

        margin-top: 10px;

    }
    :last-child {
        margin-bottom: 0;
    }

    .el-col {
        border-radius: 4px;
    }

    .bg-purple-dark {
        background: #99a9bf;
    }

    .bg-purple {
        background: #d3dce6;
    }

    .bg-purple-light {
        background: #e5e9f2;
    }

    .grid-content {
        border-radius: 4px;
        min-height: 36px;
        color: #606266;
    }

    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
</style>
