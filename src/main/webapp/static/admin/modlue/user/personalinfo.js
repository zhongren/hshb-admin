$(document)
    .ready(
        function () {

            var rule = {
                m_oldpass: {
                    name: "旧密码",
                    method: {
                        required: true,
                    }

                },
                m_newpass: {
                    name: "新密码",
                    method: {
                        required: true,
                    }
                },
                m_newpass2: {
                    name: "新密码确认",
                    method: {
                        required: true
                    }
                }
            };
            validator.init(rule);
        });
function updatePersonalinfo() {
    var userId = $("#m_userId").val();
    var account = $("#m_account").val();
    var oldpass = $("#m_oldpass").val();
    var newpass = $("#m_newpass").val();
    var newpass2 = $("#m_newpass2").val();
    $.ajaxInvoke({
        url: G_CTX_ROOT + "/personalinfo/update",
        type: "post",
        datatype: "json",
        data: {
            p_id:userId,
            p_account: account,
            p_oldpass: oldpass,
            p_newpass: newpass,
            p_newpass2: newpass2
        },
        success: function (data) {
            $("#myModal").modal("hide");
            msgBox(data.state, data.msg);
            dataTable.fnDraw();
        }
    });
}

