function data_create(){
    alert('저장');

    let name = $("#name").val();
    let phone = $("#phone").val();
    let memo = $("#memo").val();

    alert(name);
    $.ajax({
        url : "create" ,
        method:"POST", // 통신 방식
        data : {"name" : name , "phone" : phone , "memo" : memo} , // 통신 데이터
        success: function(re){ // 통신 응답
            alert("create통신");
        }
    });
}

function data_read(){
    alert('호출');
     $.ajax({
            url:"read",
            method:"get",
            success: function(re){
                alert("read통신");
                console.log(re);
            }
        });
}

function data_update(){
    alert('수정');
     $.ajax({
            url:"update",
             method:"put",
            success: function(re){
                alert("update통신");
            }
        });
}

function data_delete(){
    alert('delete');
     $.ajax({
            url:"delete",
             method:"delete",
            success: function(re){
                alert("delete통신");
            }
        });
}