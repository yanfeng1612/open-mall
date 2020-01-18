import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/dashboard',
                    component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Dashboard.vue'),
                    meta: { title: '系统首页' }
                },
                {
                    path: '/icon',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Icon.vue'),
                    meta: { title: '自定义图标' }
                },
                {
                    path: '/table',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/BaseTable.vue'),
                    meta: { title: '基础表格' }
                },

                {
                    path: '/userList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/user/list.vue'),
                    meta: { title: '用户表' }
                },
                {
                    path: '/userEdit',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/user/edit.vue'),
                    meta: { title: '用户表' }
                },
                {
                    path: '/userDetail',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/user/detail.vue'),
                    meta: { title: '用户表' }
                },

                {
                    path: '/productList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/product/list.vue'),
                    meta: { title: '商品基本属性表' }
                },
                {
                    path: '/productEdit',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/product/edit.vue'),
                    meta: { title: '商品基本属性表' }
                },
                {
                    path: '/productDetail',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/product/detail.vue'),
                    meta: { title: '商品基本属性表' }
                },

                {
                    path: '/productBrandList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/productBrand/list.vue'),
                    meta: { title: '商品品牌表' }
                },
                {
                    path: '/productBrandEdit',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/productBrand/edit.vue'),
                    meta: { title: '商品品牌表' }
                },
                {
                    path: '/productBrandDetail',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/productBrand/detail.vue'),
                    meta: { title: '商品品牌表' }
                },

                {
                    path: '/productCategoryList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/productCategory/list.vue'),
                    meta: { title: '商品分类表' }
                },
                {
                    path: '/productCategoryEdit',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/productCategory/edit.vue'),
                    meta: { title: '商品分类表' }
                },
                {
                    path: '/productCategoryDetail',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/productCategory/detail.vue'),
                    meta: { title: '商品分类表' }
                },

                {
                    path: '/orderCartList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderCart/list.vue'),
                    meta: { title: '订单购物车' }
                },
                {
                    path: '/orderCartEdit',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderCart/edit.vue'),
                    meta: { title: '订单购物车' }
                },
                {
                    path: '/orderCartDetail',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderCart/detail.vue'),
                    meta: { title: '订单购物车' }
                },

                {
                    path: '/orderDetailList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderDetail/list.vue'),
                    meta: { title: '订单明细表' }
                },
                {
                    path: '/orderDetailEdit',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderDetail/edit.vue'),
                    meta: { title: '订单明细表' }
                },
                {
                    path: '/orderDetailDetail',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderDetail/detail.vue'),
                    meta: { title: '订单明细表' }
                },

                {
                    path: '/orderMasterList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderMaster/list.vue'),
                    meta: { title: '订单master表' }
                },
                {
                    path: '/orderMasterEdit',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderMaster/edit.vue'),
                    meta: { title: '订单master表' }
                },
                {
                    path: '/orderMasterDetail',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/orderMaster/detail.vue'),
                    meta: { title: '订单master表' }
                },
                
                {
                    path: '/tabs',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/Tabs.vue'),
                    meta: { title: 'tab选项卡' }
                },
                {
                    path: '/form',
                    component: () => import(/* webpackChunkName: "form" */ '../components/page/BaseForm.vue'),
                    meta: { title: '基本表单' }
                },
                {
                    // 富文本编辑器组件
                    path: '/editor',
                    component: () => import(/* webpackChunkName: "editor" */ '../components/page/VueEditor.vue'),
                    meta: { title: '富文本编辑器' }
                },
                {
                    // markdown组件
                    path: '/markdown',
                    component: () => import(/* webpackChunkName: "markdown" */ '../components/page/Markdown.vue'),
                    meta: { title: 'markdown编辑器' }
                },
                {
                    // 图片上传组件
                    path: '/upload',
                    component: () => import(/* webpackChunkName: "upload" */ '../components/page/Upload.vue'),
                    meta: { title: '文件上传' }
                },
                {
                    // vue-schart组件
                    path: '/charts',
                    component: () => import(/* webpackChunkName: "chart" */ '../components/page/BaseCharts.vue'),
                    meta: { title: 'schart图表' }
                },
                {
                    // 拖拽列表组件
                    path: '/drag',
                    component: () => import(/* webpackChunkName: "drag" */ '../components/page/DragList.vue'),
                    meta: { title: '拖拽列表' }
                },
                {
                    // 拖拽Dialog组件
                    path: '/dialog',
                    component: () => import(/* webpackChunkName: "dragdialog" */ '../components/page/DragDialog.vue'),
                    meta: { title: '拖拽弹框' }
                },
                {
                    // 国际化组件
                    path: '/i18n',
                    component: () => import(/* webpackChunkName: "i18n" */ '../components/page/I18n.vue'),
                    meta: { title: '国际化' }
                },
                {
                    // 权限页面
                    path: '/permission',
                    component: () => import(/* webpackChunkName: "permission" */ '../components/page/Permission.vue'),
                    meta: { title: '权限测试', permission: true }
                },
                {
                    path: '/404',
                    component: () => import(/* webpackChunkName: "404" */ '../components/page/404.vue'),
                    meta: { title: '404' }
                },
                {
                    path: '/403',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/403.vue'),
                    meta: { title: '403' }
                },
                {
                    path: '/donate',
                    component: () => import(/* webpackChunkName: "donate" */ '../components/page/Donate.vue'),
                    meta: { title: '支持作者' }
                }
            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
});
