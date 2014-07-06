TRACE: Entering controller:WizardStep2:evaluateStep function app.js:22008
============== ajax ============== wizard.launch_bootstrap 
Object {bootStrapData: "{"verbose":true,"sshKey":"-----BEGIN RSA PRIVATE K…bd2.b4.internal.chinacloudapp.cn"],"user":"root"}"}
bootStrapData: "{"verbose":true,"sshKey":"-----BEGIN RSA PRIVATE KEY-----\nMIIEpAIBAAKCAQEA8dUORm4ksjv3z/IjVFp31leHfCi5xBItgFYqcaFNqHMgclJm\nl7BaRLYIrDuKC3k1ac07SBnOMQ9g6N7GX22Cs9MQavQTZjMcSWrT6WbsRFcF8bK2\n6AUQoes5MVtQx+Io7AfN+bns+BBAqvIiBx4aiRo80m94VwGq5YWG1o8gRryaOrJu\nSfipIzurhc0CNNkvimqD642CDVncZCFy9ewyh0mcOlUoTmCcIyCD3HIsHDI6zvLm\nGUHtyo4jrGIuMdVsFkjb42d2IhOZPNKeEJYRvLzDX4mgx1CrNij1Fw7KLD5QNHpo\nBfo0Nv0KqSWpYFW2nCB17gpD0osZgKkBdzS6xwIBIwKCAQEAs6WVk2fDfRaa1P0E\nTUqE6F5HY4v3tjljoSoQ5rJW8imjExij+6eTg3/pL3yvsMBw0kCvsedItrr3iGr5\nwztoaFOly8tBnGB7ab0Sct6+JCNjgFjfpQsTq3uJkmEXb+nVQZ9lz3QsYIEaGJac\n71gw+CIejbHkXeP7S2qBbC/O1XS3syM44zEcpO1dXWMPNzx92DnR/VdTKnnF+YyX\nvBU5y0LGLDsMdtTp5Rj7tiDpkEGuJYSU26dLANoC5jp74TyxO/qVWzGRa/qQLamQ\nMnPUZgyDv105WetftdupSX51ZUr2mhClwkFbt3Y4xsy/a/NVi22hBDQ2PCvD1mJs\nFycVawKBgQD9T4IAioCjH3HIKGj6XjDY4vuCaSfglfnZqpc+dHcmncK+lA62SjAm\nPQjRnCM4Xm/pg4jzGAYY5RPMjDcRkssAMFqPfQ7KAM+OY4c1EkUK67N7rR1T8/fa\n7Lo/iKoBGffDvfH8ZHCniSYI0OAwakG1f9K15ACvPUdFagCFwvrd+QKBgQD0Zlmh\nKywQr54NEOiHDE0PtZdTI4PFNFmfmtbKtX/bpqz6Q1lrFXROu4nB3tPgtqT6jxAW\n7T0XUKOh/fATZf2ksrqDV+S3I5ohYL/Ea6Fo5TOCpvinAa+oD7NRq3WhMU3xutR4\nzUVCcfLwfeMU0RFcuTosNZvpHOGHicGHvHGOvwKBgQDnmSZm5QflmReSbhbWR30e\nEVr648ywFBeicBVAanuRBURWeLz+b7b+Y7BKnWIHpsy4Pb8KJJfcPygLeOHkLnB1\nM4X/iEgJJVANJ8wTQ+dacRkgnkazKDMRTXcVhEOpPFA9734ollheqUdYhHUzlFlV\nfC5dKDsj4EEphXzSEVpkiwKBgQDfc4Ulo9CESMsEob6nW7QrnrY9YkyXC0qgjZEu\nXMyrkRMt9G8C0clsjjTOgpXUxD8Q99QyN/1XJSfkkGZ4IrwES6M2QbsrGTx2SdPm\nyM4Wwu1EQONW3PhfJEwtaZAeWPbOYaxRMLRaAcgsVdbudgE+1TyAMQOTTZr/k+Qk\nVIUUywKBgQCz+0IOwE6nrS6A4aD2agFz9PX50zfSBrssr7KN2dvDGcN7Wup5qwo1\nJaqL3blGGnZKXKekOSVL+1RA425B8+XMM5BVu0ZBM7omfqtbrEWvIKtw61aiJwj0\nDIhDokxLxlHSLHbSzvIKMaSBVbUkSsLoDap8gYxkdyx3nR6kQxfJlA==\n-----END RSA PRIVATE KEY-----","hosts":["bd12.bd1.b1.internal.chinacloudapp.cn","bd2.bd2.b4.internal.chinacloudapp.cn"],"user":"root"}"
__proto__: Object
 app.js:100736
TRACE: The url is: /api/v1/bootstrap app.js:100769
TRACE: POST bootstrap succeeded app.js:19780
Status code 200: Success. app.js:39720
============== ajax ============== ambari.service undefined app.js:100736
STATEMANAGER: Sending event 'next' to state root.installer.step2. vendor.js:17327
TRACE: Entering db:setinstallOptions;value:  
Object {hostNames: "bd12.bd1.b1.internal.chinacloudapp.cn↵bd2.bd2.b4.internal.chinacloudapp.cn", manualInstall: false, useSsh: true, javaHome: "/usr/jdk/jdk1.6.0_31", localRepo: false…}
 app.js:104503
installerController: saved installOptions 
Object {hostNames: "bd12.bd1.b1.internal.chinacloudapp.cn↵bd2.bd2.b4.internal.chinacloudapp.cn", manualInstall: false, useSsh: true, javaHome: "/usr/jdk/jdk1.6.0_31", localRepo: false…}
 app.js:19818
TRACE: Entering db:sethosts;value:  
Object {bd12.bd1.b1.internal.chinacloudapp.cn: Object, bd2.bd2.b4.internal.chinacloudapp.cn: Object}
 app.js:104503
installerController: saved hosts 
Object {bd12.bd1.b1.internal.chinacloudapp.cn: Object, bd2.bd2.b4.internal.chinacloudapp.cn: Object}
 app.js:19818
STATEMANAGER: Entering root.installer.step3 vendor.js:17564
in installer.step3:connectOutlets app.js:51607
TRACE: Entering db:setWizardCurrentStep function app.js:104725
Trace: Entering db:getLoginName function app.js:104915
Trace: Entering db:getWizardCurrentStep function for  installer app.js:104974
getWizardCurrentStep: loginName=admin, currentStep=3 app.js:49740
returning currentStep=3 app.js:49744
TRACE: Entering db:gethosts app.js:104494
Trace: Entering db:getAuthenticated function app.js:104921
TRACE: Entering db:getStartIndex function app.js:104951
TRACE: Entering db:getFilterConditions function app.js:104933
TRACE: Loading step3: Confirm Hosts app.js:22459
TRACE: Entering db:setbootStatus;value:  false app.js:104503
TRACE: Entering db:getbootStatus app.js:104494
============== ajax ============== wizard.step3.is_hosts_registered undefined app.js:100736
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 1} app.js:100736
TRACE: The url is: /api/v1/services/AMBARI/components/AMBARI_SERVER app.js:100769
Status code 200: Success. app.js:39720
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
TRACE: The url is: /api/v1/hosts app.js:100769
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 2} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 3} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 4} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 5} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 6} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 7} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 8} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 9} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 10} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 11} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
registration started at 1404661704205 app.js:22771
============== ajax ============== wizard.step3.is_hosts_registered undefined app.js:100736
Status code 200: Success. app.js:39720
TRACE: The url is: /api/v1/hosts app.js:100769
registration attempt... app.js:22808
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 12} app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.is_hosts_registered undefined app.js:100736
TRACE: The url is: /api/v1/hosts app.js:100769
registration attempt... app.js:22808
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.bootstrap Object {bootRequestId: 11, numPolls: 13} app.js:100736
============== ajax ============== wizard.step3.is_hosts_registered undefined app.js:100736
TRACE: The url is: /api/v1/bootstrap/11 app.js:100769
TRACE: In success function for the GET bootstrap call app.js:22730
Status code 200: Success. app.js:39720
TRACE: The url is: /api/v1/hosts app.js:100769
registration attempt... app.js:22808
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.is_hosts_registered undefined app.js:100736
TRACE: The url is: /api/v1/hosts app.js:100769
registration attempt... app.js:22808
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.is_hosts_registered undefined app.js:100736
TRACE: The url is: /api/v1/hosts app.js:100769
registration attempt... app.js:22808
Status code 200: Success. app.js:39720
============== ajax ============== wizard.step3.is_hosts_registered undefined app.js:100736
TRACE: The url is: /api/v1/hosts app.js:100769
registration attempt... app.js:22808
============== ajax ============== wizard.step3.host_info undefined app.js:100736
Status code 200: Success. app.js:39720
TRACE: The url is: /api/v1/hosts?fields=Hosts/total_mem,Hosts/cpu_count,Hosts/disk_info,Hosts/last_agent_env,Hosts/host_name,Hosts/os_type,Hosts/os_arch,Hosts/ip app.js:100769
Status code 200: Success. 
