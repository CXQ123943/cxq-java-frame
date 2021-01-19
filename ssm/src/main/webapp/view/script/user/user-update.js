$(() => {
    let id = sessionStorage.getItem("id");
    selectById(id);
    $("#submit-btn").click(() => submitUpdateForm());
});

function selectById(id) {
    $.ajax({
        "url": `/ssm/api/user/find-by-id`,
        "data": {"id": id},
        "success": response => {
            if (response["status"] === 200) {
                renderUser(response["data"]);
            } else {
                alert(response["msg"]);
            }
        }
    });
}

function renderUser(user) {
    $("#id-ipt").val(user["id"]);
    $("#name-ipt").val(user["name"]);
    $("#age-ipt").val(user["age"]);
    $(`#rdo-${user["gender"]}`).attr("checked", "checked");
}

function submitUpdateForm() {
    $.ajax({
        "url": `/ssm/api/user/update-by-id`,
        "data": $("#update-form").serialize(),
        "success": response => {
            console.log(response);
            alert(response["msg"]);
            if (response["status"] === 200) {
                location.href = `/ssm/view/html/user/user.html`;
            }
        }
    });
}

