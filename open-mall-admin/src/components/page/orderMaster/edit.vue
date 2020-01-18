<template>
    <el-form :rules="rules" :model="formData" ref="formData" label-width="160px" class="demo-ruleForm">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i> 订单master表</el-breadcrumb-item>
                <el-breadcrumb-item>编辑订单master表</el-breadcrumb-item>
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
                    <el-form-item label="全局唯一order_key：" prop="全局唯一order_key">
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
                    <el-form-item label="渠道key：" prop="渠道key">
                        <el-input v-model="formData.channelKey" placeholder="channelKey"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="渠道名称：" prop="渠道名称">
                        <el-input v-model="formData.channelName" placeholder="channelName"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="流水：" prop="流水">
                        <el-input v-model="formData.flowAmount" placeholder="flowAmount"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="实收：" prop="实收">
                        <el-input v-model="formData.paidAmount" placeholder="paidAmount"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="优惠：" prop="优惠">
                        <el-input v-model="formData.promotionAmount" placeholder="promotionAmount"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="总数量：" prop="总数量">
                        <el-input v-model="formData.totalNumber" placeholder="totalNumber"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="总重量（单位克）：" prop="总重量（单位克）">
                        <el-input v-model="formData.totalWeight" placeholder="totalWeight"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="订单状态 40 已完成  30 作废  20 已退款：" prop="订单状态 40 已完成  30 作废  20 已退款">
                        <el-input v-model="formData.orderStatus" placeholder="orderStatus"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="订单时间，包含不限于预定时间、付款时间等,精确到分：" prop="订单时间，包含不限于预定时间、付款时间等,精确到分">
                        <el-input v-model="formData.orderTime" placeholder="orderTime"></el-input>
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
                    <el-form-item label="退款总金额：" prop="退款总金额">
                        <el-input v-model="formData.refundAmount" placeholder="refundAmount"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="支付方式：" prop="支付方式">
                        <el-input v-model="formData.payWayType" placeholder="payWayType"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label=" 0 未知   1 支付宝   2 微信：" prop=" 0 未知   1 支付宝   2 微信">
                        <el-input v-model="formData.payWayTypeID" placeholder="payWayTypeID"></el-input>
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
                        "url": "/api/orderMaster/detail",
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
                            "url": "/api/orderMaster/updateById",
                            "data": this.formData
                            , "callback": function (redata) {
                                self.$message({
                                    type: 'success',
                                    message: '保存成功!'
                                });
                                self.$router.push({path: '/orderMasterList'});
                            }
                        });

                    }
                });
            },
            toCancel() {
                this.$router.push({path: '/orderMasterList'});
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
