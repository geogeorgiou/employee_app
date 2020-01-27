// validator for all input fields
// with jQuery checks for "rules"
// and returns corresponding error "messages"

// used in /user/home + /register

jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-z]+$/i.test(value);
}, "Enter letters only!");

jQuery(function ($){

    const empValidator = $('#employeeForm');

    if (empValidator.validate) {
        empValidator.validate({
            rules: {

                id: {
                    required: true
                },
                name: {
                    required: true,
                    lettersonly: true
                },
                dateOfHire: {
                    required: true
                }
                // ,

                // supervisor:{
                //     required: true
                // },



            },
            messages: {

                id: {
                    required: 'Enter id!',
                },
                name: {
                    required: 'Enter employee name!'
                },
                dateOfHire: {
                    required: 'Enter hire date!'
                }
                // ,
                // supervisor: {
                //     required: 'Enter supervisor!'
                // }

            }
        });
    }


});

