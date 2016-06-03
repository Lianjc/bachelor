(function($) {

    $(function() {
        $("#addDepartmentSubmit").click(function() {
            $.post("/action/CFO/department",
                { "description" : $("input[name='description']").val() }
            );
        });
    });

})(jQuery);
