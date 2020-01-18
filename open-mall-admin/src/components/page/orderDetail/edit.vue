<template>
    <el-form :rules="rules" :model="formData" ref="formData" label-width="160px" class="demo-ruleForm">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i> 订单明细表</el-breadcrumb-item>
                <el-breadcrumb-item>编辑订单明细表</el-breadcrumb-item>
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
                    <el-form-item label="order_key：" prop="order_key">
                        <el-input v-model="formData.orderKey" placeholder="orderKey"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="用户id：" prop="用户id">
                        <el-input v-model="formData.userId" placeholder="userId"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="用户名称：" prop="用户名称">
                        <el-input v-model="formData.userName" placeholder="userName"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="用户性别  0-未知   1-男  2-女：" prop="用户性别  0-未知   1-男  2-女">
                        <el-input v-model="formData.sex" placeholder="sex"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="手机号：" prop="手机号">
                        <el-input v-model="formData.phone" placeholder="phone"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品id：" prop="商品id">
                        <el-input v-model="formData.productId" placeholder="productId"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品名称：" prop="商品名称">
                        <el-input v-model="formData.productName" placeholder="productName"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品单位：" prop="商品单位">
                        <el-input v-model="formData.unit" placeholder="unit"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品分类id：" prop="商品分类id">
                        <el-input v-model="formData.categroyId" placeholder="categroyId"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品分类名称：" prop="商品分类名称">
                        <el-input v-model="formData.categroyName" placeholder="categroyName"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品品牌id：" prop="商品品牌id">
                        <el-input v-model="formData.brandId" placeholder="brandId"></el-input>
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
                    <el-form-item label="售价：" prop="售价">
                        <el-input v-model="formData.price" placeholder="price"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="已点数量：" prop="已点数量">
                        <el-input v-model="formData.productCount" placeholder="productCount"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="总价：" prop="总价">
                        <el-input v-model="formData.totalAmount" placeholder="totalAmount"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="备注：" prop="备注">
                        <el-input v-model="formData.remark" placeholder="remark"></el-input>
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
                        "url": "/api/orderDetail/detail",
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
                            "url": "/api/orderDetail/updateById",
                            "data": this.formData
                            , "callback": function (redata) {
                                self.$message({
                                    type: 'success',
                                    message: '保存成功!'
                                });
                                self.$router.push({path: '/orderDetailList'});
                            }
                        });

                    }
                });
            },
            toCancel() {
                this.$router.push({path: '/orderDetailList'});
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
