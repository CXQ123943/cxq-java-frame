$(() => {
    pagingQuery(1, 1);

    let sizeSel = $("#size-sel");
    sizeSel.change(() => pagingQuery(1, sizeSel.val()));

    $("#insert-btn").click(() => {
        location.href = "view/html/user/user-insert.html";
    });

    $("#delete-btn").click(() => {
        if (confirm("确认删除吗？")) {
            deleteByIds();
        }
    });
});

function deleteByIds() {
    $.ajax({
        "url": "/ssm/api/user/delete-by-ids",
        "type": "post",
        "data": $("#delete-form").serialize(),
        "success": response => {
            if (response["status"] === 200) {
                alert("删除成功！");
                location.href = `/ssm/view/html/user/user.html`;
            } else {
                alert(response["message"]);
            }
        }
    });
}

function pagingQuery(pageNum, pageSize) {
    $.ajax({
        "url": "/ssm/api/user/paging",
        "type": "post",
        "data": {"pageNum": pageNum, "pageSize": pageSize},
        "success": response => {
            if (response["status"] === 200) {
                buildData(response["data"]['list']);
                buildPage(response["data"]);
            } else {
                console.log("error" + response["message"]);
            }
        }
    });
}

function buildData(data) {
    let table = $("#table-tbody").html("");
    $.each(data, (i, v) => {
        let tr = $("<tr></tr>").appendTo(table);
        $(`<td><label><input type="checkbox" name="ids" value='${v["id"]}'/></label></td>`).appendTo(tr);
        $(`<td>${v["id"]}</td>`).appendTo(tr);
        $(`<td>${v["name"]}</td>`).appendTo(tr);
        $(`<td>${v["gender"] === 1 ? "男" : v["gender"] === 0 ? "女" : v["gender"] === 2 ? "保密" : ""}</td>`).appendTo(tr);
        $(`<td>${v["age"]}</td>`).appendTo(tr);
        let updateBtn = $(`<a href="javascript:" >修改</a>`);

        updateBtn.on("click", () => {
            sessionStorage.setItem("id", v["id"]);
            location.href = "/ssm/view/html/user/user-update.html";
        });

        let updateTd = $(`<td></td>`);
        updateBtn.appendTo(updateTd);
        updateTd.appendTo(tr);
    });
}

function buildPage(pageInfo) {
    let page = pageInfo["pageNum"];
    let size = pageInfo["pageSize"];
    let pages = pageInfo["pages"];
    let pageList = pageInfo["navigatepageNums"];
    let pageUl = $("#page-ul").html("");

    buildPrevAndFirstPage(page, size, pageUl);

    buildPageList(page, pageList, size, pageUl);

    buildPrevAndLastPage(page, size, pages, pageUl);
}

function buildPrevAndFirstPage(page, size, pageUl) {
    if (page === 1) {
        $(`<li class="disabled"><a href='javaScript:'>首页</a></li>`).appendTo(pageUl);
        $(`<li class="disabled"><a href='javaScript:'>&laquo;</a></li>`).appendTo(pageUl);
    } else {
        $(`<li><a href='javaScript:pagingQuery(${1}, ${size});'>首页</a></li>`).appendTo(pageUl);
        $(`<li><a href='javaScript:pagingQuery(${page - 1}, ${size});'>&laquo;</a></li>`).appendTo(pageUl);
    }
}

function buildPageList(page, pageList, size, pageUl) {
    $.each(pageList, (i, v) => {
        let li = $(`<li><a>${v}</a></li>`).appendTo(pageUl);
        if (parseInt(v) !== page) {
            li.click(() => pagingQuery(parseInt(v), size));
        }
    });
}

function buildPrevAndLastPage(page, size, pages, pageUl) {
    if (page === pages) {
        $(`<li class="disabled"><a href='javaScript:'>&raquo;</a></li>`).appendTo(pageUl);
        $(`<li class="disabled"><a href='javaScript:'>尾页</a></li>`).appendTo(pageUl);
    } else {
        $(`<li><a href='javaScript:pagingQuery(${page + 1}, ${size});'>&raquo;</a></li>`).appendTo(pageUl);
        $(`<li><a href='javaScript:pagingQuery(${pages}, ${size});'>尾页</a></li>`).appendTo(pageUl);
    }
}
