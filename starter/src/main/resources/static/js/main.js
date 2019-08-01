/**
 * Created by Mr.Zhang on 2017/8/25.
 */

// 设置JQuery Validation默认样式
$.validator.setDefaults({
    errorElement: 'div',
    errorPlacement: function(error, element) {
        error.addClass('layui-form-mid validation-error');
        error.appendTo(element.parent().parent());
    },
    highlight: function(element, errorClass) {
        $(element).addClass('layui-form-danger');
    },
    unhighlight: function(element, errorClass) {
        $(element).removeClass('layui-form-danger');
    }
});

// 添加中国手机号码验证
$.validator.addMethod("phoneCN", function(value, element) {
    return this.optional(element) || /^1\d{10}$/i.test(value);
}, "Please specify a valid phone number.");
$.extend( $.validator.messages, {
    phoneCN: "手机号码格式不正确"
});