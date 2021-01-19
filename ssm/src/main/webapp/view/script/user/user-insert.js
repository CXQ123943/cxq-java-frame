$(() => {
    $("#submit-btn").click(() => submitInsertForm());
});

function submitInsertForm() {
    $.ajax({
        "url": `/ssm/api/user/insert`,
        "type": "post",
        "data": $("#insert-form").serialize(),
        "success": response => {
            alert(response["msg"]);
            if (response["status"] === 200) {
                location.href = `/ssm/view/html/user/user.html`;
            }
        }
    });
}