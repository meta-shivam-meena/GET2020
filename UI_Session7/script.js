 var empDetails;
        var vehicleDetails;
        var planDetails;
        //This function submit employee form and validate it's inputs
        function submitEmpForm()
        {
            if(validateEmpForm())
            {
                empDetails = document.getElementById('employee-form');
                var v1 = document.getElementById('EmpName').value + '';
                var v2 = document.getElementById('EmpContactNumber').value + '';
                document.getElementById('EmpId').value = Date.now();
                hideEmpForm();
                showVehicleForm();
            }
        }
        //This funcation submit vehicle form and validate it's inputs
        function submitVehicleForm()
        {
            if(validateVehicleForm())
            {
                vehicleDetails = document.getElementById('vehicleForm');
                hideVehicleForm();
                showSelectPlanForm();
                showCurrency();
            }
        }
        //This function submit plan selector form 
        function submitPlanForm()
        {
            planDetails = document.getElementById('planForm');
            hideSelectPlanForm();
            showConfirmDetailsForm();
            document.getElementById('CDEmpName').innerHTML = empDetails.elements[0].value;
            document.getElementById('CDVehicleType').innerHTML = vehicleDetails.elements[1].value;
            document.getElementById('CDVehicleNumber').innerHTML = vehicleDetails.elements[2].value;
            document.getElementById('CDPlan').innerHTML = planDetails.elements[1].value;
        }
        //This function display prices according to selected currrency
        function showCurrency()
        {
            var currency = document.getElementById('CurrencySelect').value;
            var vehicleType = vehicleDetails.elements[1].value;
            var dataRow;
            var currencyArray = [[5, 100, 500], [10, 200, 1000], [20, 500, 3500]];

            if(vehicleType == "Cycle")
            {
                dataRow = 0;
            }
            else if(vehicleType == "MotorCycle")
            {
                dataRow = 1;
            }
            else if(vehicleType == "FourWheeler")
            {
                dataRow = 2;
            }
            if(currency == "INR")
            {
                document.getElementById('DailyCost').innerHTML = currencyArray[dataRow][0];
                document.getElementById('MonthlyCost').innerHTML = currencyArray[dataRow][1];
                document.getElementById('YearlyCost').innerHTML = currencyArray[dataRow][2];
            }
            if(currency == "USD")
            {
                document.getElementById('DailyCost').innerHTML = convertToUSD(currencyArray[dataRow][0]);
                document.getElementById('MonthlyCost').innerHTML = convertToUSD(currencyArray[dataRow][1]);
                document.getElementById('YearlyCost').innerHTML = convertToUSD(currencyArray[dataRow][2]);
            }
            if(currency == "YEN")
            {
                document.getElementById('DailyCost').innerHTML = convertToYEN(currencyArray[dataRow][0]);
                document.getElementById('MonthlyCost').innerHTML = convertToYEN(currencyArray[dataRow][1]);
                document.getElementById('YearlyCost').innerHTML = convertToYEN(currencyArray[dataRow][2]);
            }
            showTotal();
        }
        //This function show totol according to selected plan
        function showTotal()
        {
            if(document.getElementById('DailyPlan').checked == true)
            {
                document.getElementById('TotalCost').value = document.getElementById('DailyCost').innerHTML;
            }
            else if(document.getElementById('MonthlyPlan').checked == true)
            {
                document.getElementById('TotalCost').value = document.getElementById('MonthlyCost').innerHTML;
            }
            else if(document.getElementById('YearlyPlan').checked == true)
            {
                document.getElementById('TotalCost').value = document.getElementById('YearlyCost').innerHTML;
            }
        }
        //validate name of employee
        function nameFunction(e)
        {
            if(e.keyCode == 13)
            {
                var empName = document.getElementById('employee-form')[0];
                if(!empName.checkValidity())
                {
                    alert("Please enter valid name");
                    return false;
                }
                else
                {
                    document.getElementById('emp-name-row').style.display = "none";
                    document.getElementById('emp-email-row').style.display = "inherit";
                    var name = document.getElementById("EmpName").value;
                    document.getElementById("message").innerHTML = "hello " + name + " please enter your email ";
                }
                return false;
            }
        }
        
        //validate email
        function emailFunction(e)
        {
            if(e.keyCode == 13)
            {
                //validating email
                var empEmail = document.getElementById('employee-form')[1];
                if(!empEmail.checkValidity())
                {
                    alert('Please enter valid email');
                    return false;
                }
                else
                {
                    document.getElementById('emp-email-row').style.display = "none";
                    document.getElementById('emp-gender-row').style.display = "inherit";
                    document.getElementById("message").innerHTML = "please select your gender ";
                }
                return false;
            }
        }

        //validate gender
        function genderFunction()
        {
            document.getElementById('emp-gender-row').style.display = "none";
            document.getElementById('emp-password-row').style.display = "inherit";
            document.getElementById('emp-confirm-password-row').style.display = "inherit";
            document.getElementById("message").innerHTML = "please enter your password ";
            return false;
        }

        function passwordFunction(e)
        {
            var empPassword = document.getElementById("EmpPassword").value;
            if(empPassword.length < 4 )
            {
                document.getElementById('EmpPassword').style.borderColor = "red";
            }
            else if(empPassword.length < 7)
            {
                document.getElementById('EmpPassword').style.borderColor = "orange";
            }
            else
            {
                document.getElementById('EmpPassword').style.borderColor = "green";
            }
            if(e.keyPress == 9)
            {
                //validating password
                var empPassword = document.getElementById('employee-form')[4];
                if(!empPassword.checkValidity())
                {
                    alert('Please enter valid password');
                    return false;
                }
                return false
            }
        }
        function confirmPassword(e)
        {
            var empPassword = document.getElementById("EmpConfirmPassword").value;
            if(empPassword.length < 4 )
            {
                document.getElementById('EmpConfirmPassword').style.borderColor = "red";
            }
            else if(empPassword.length < 7)
            {
                document.getElementById('EmpConfirmPassword').style.borderColor = "orange";
            }
            else
            {
                document.getElementById('EmpConfirmPassword').style.borderColor = "green";
            }
            
            if(e.keyCode == 13)
            {
                //validating password and confirm password
                var empPassword = document.getElementById('employee-form')[4];
                if(!empPassword.checkValidity())
                {
                    alert('Please enter valid password');
                    return false;
                }
                else
                {
                    var empConfirmPassword = document.getElementById('employee-form')[5];
                    if(!empConfirmPassword.checkValidity())
                    {
                        alert('Please enter valid confirm password');
                        return false;
                    }
                    else if(empConfirmPassword.value != empPassword.value)
                    {
                        alert('Please enter same password');
                        return false;
                    }
                    else
                    {
                        document.getElementById('emp-password-row').style.display = "none";
                        document.getElementById('emp-confirm-password-row').style.display = "none";
                        document.getElementById("message").innerHTML = "please enter your contact ";
                        document.getElementById("emp-contact-row").style.display = "inherit";
                        document.getElementById("emp-submit-row").style.display = "inherit";
                        return true;
                    }
                }
                return false
            }
        }
        //This function submit confirm details form
        function submitConfirmDetails()
        {
            document.getElementById('confirmDetailsForm').submit();
            alert('Registration Succefull');
        }
        //This function cancel the registration
        function cancelRegistration()
        {
            document.getElementById('confirmDetailsForm').submit();
            alert('Registration Cancelled');
        }
        //This function convert INR to USD
        function convertToUSD(value)
        {
            return (Math.round(( value / 72 ) * 100) / 100);
        }
        //This function convert INR to YEN
        function convertToYEN(value)
        {
            return (Math.round(( value * 1.53 ) * 100) / 100);
        }
        //This function hide employee form
        function hideEmpForm()
        {
            document.getElementById('employee-form-container').style.display = "none";
        }
        //This function show the vehicle form
        function showVehicleForm()
        {
            document.getElementById('VehicleRegisterDiv').style.display = "inherit";
        }
        //This function hide the vehicle form
        function hideVehicleForm()
        {
            document.getElementById('VehicleRegisterDiv').style.display = "none";
        }
        //This fuction show the select plan form
        function showSelectPlanForm(){
            document.getElementById('SelectPlanDiv').style.display = "inherit";
        }
        //This function hide the select plan form
        function hideSelectPlanForm()
        {
            document.getElementById('SelectPlanDiv').style.display = "none";
        }
        //This function show the confirm details form
        function showConfirmDetailsForm()
        {
            document.getElementById('ConfirmDetailsDiv').style.display = "inherit";
        }
        //This function hide the confirm details form
        function hideConfirmDetailsForm()
        {
            document.getElementById('ConfirmDetailsDiv').style.display = "none";
        } 
        //This function validate Emplyoee form
        function validateEmpForm()
        {
            
            //validating gender
            if(document.getElementById('EmpGenderM').checked == false && document.getElementById('EmpGenderF').checked == false)
            {
                alert('Please select gender');
                return false;
            }
            
            //validating contact number
            var empContact = document.getElementById('employee-form')[6];
            if(!empContact.checkValidity())
            {
                alert('Please enter valid contact number');
                return false;
            }
            return true;
        } 
        
        function vehicleName(e)
        {
            if(e.keyCode == 13)
            {
                var vehicleName = document.getElementById('vehicleForm')[0];
                if(!vehicleName.checkValidity())
                {
                    alert('Please enter valid vehicle name');
                    return false;
                }
                else
                {
                    document.getElementById('vehicle-name').style.display = "none";
                    document.getElementById('vehicle-type').style.display = "inherit";
                    document.getElementById('vehicle-message').innerHTML = "please select vehicle type";
                }
                return false
            }
        }
        function vehicleType()
        {
            
            document.getElementById('vehicle-type').style.display = "none";
            document.getElementById('vehicle-number').style.display = "inherit";
            document.getElementById('vehicle-empId').style.display = "inherit";
            document.getElementById('vehicle-message').innerHTML = "please Enter your vehicle number";
               
        }
        function vehicleNumber(e)
        {
            if(e.keyCode == 13)
            {
                var vehicleNumber = document.getElementById('vehicleForm')[2];
                if(vehicleNumber.value == "")
                {
                    alert('Please enter valid vehicle number');
                    return false;
                }
                else
                {
                    document.getElementById('vehicle-number').style.display = "none";
                    document.getElementById('vehicle-empId').style.display = "none";
                    document.getElementById('vehicle-identification').style.display = "inherit";
                    document.getElementById('vehicle-submit').style.display = "inherit";
                    document.getElementById('vehicle-message').innerHTML = "please write your vehicle identification";
                }
                return false
            }
        }
        //This function validate vehicle form inputs
        function validateVehicleForm()
        {
            var vehicleIdentification = document.getElementById('vehicleForm')[4];
            if(vehicleIdentification.value == "")
            {
                alert('Please enter vehicle identifications');
                return false;
            }
            return true;
        }