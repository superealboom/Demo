function sendBack() {
    console.log(descDirect)
    $.ajax({
        url: PATH + '/customer/sendBack',
        method: 'get',
        data: {
            backName: '李明'
        },
        success: function (data) {
            console.log(data)
        }
    })
}