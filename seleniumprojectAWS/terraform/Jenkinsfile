pipeline {

    parameters {
        booleanParam(name: 'autoApprove', defaultValue: false, description: 'Automatically run apply after generating plan?')
    } 
    environment {
        AWS_ACCESS_KEY_ID     = credentials('AWS_ACCESS_KEY_ID')
        AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
    }

   agent  any
   
    tools {
        // Define the Terraform installation using the tool type 'terraform'
        terraform "terraform_1.5.3"
    }
    stages {
        stage('Plan') {
            steps {
                script {
                    def terraformDir = "$WORKSPACE/seleniumprojectAWS/terraform"
                    bat "terraform --version" 
                    bat "cd ${terraformDir} && terraform init"
                    bat "cd ${terraformDir} && terraform plan -out tfplan"
                    bat "cd ${terraformDir} && terraform show -no-color tfplan > tfplan.txt"
                }
            }
        }
        stage('Approval') {
           when {
               not {
                   equals expected: true, actual: params.autoApprove
               }
           }

           steps {
               script {
                    def plan = readFile 'terraform/tfplan.txt'
                    input message: "Do you want to apply the plan?",
                    parameters: [text(name: 'Plan', description: 'Please review the plan', defaultValue: plan)]
               }
           }
       }

        stage('Apply') {
            steps {
                bat "cd $WORKSPACE/seleniumprojectAWS/terraform && terraform apply -input=false tfplan"
            }
        }
    }

  }
