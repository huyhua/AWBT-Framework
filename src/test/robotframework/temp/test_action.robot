* ACTION DEFINITION			launch app
* DESCRIPTION				Launch app and choose language

#							name					default value		description
argument					device					n/a					udid or device name. System detects and uses automatically the first connected device by default.
argument					version					n/a
argument					platform				android				app platform (ios, android)
argument					build					beta				app build: alpha, beta, gold
argument					build number			latest				app build number on hockeyapp. Default is latest build.
argument					language				Français			choose lanague for app.

#							condition
if							'${platform}'=='android' and '${build}'=='beta' and '${build number}'='latest'

#														appid								
${app path}=				download from hockey app	${ANDR_BETA_ID}

end if

#							condition
if							'${platform}'=='android' and '${build}'=='beta' and '${build number}'!='latest'

#														appid						versionid		
${app path}=				download from hockey app	${ANDR_BETA_ID}				${build number}
		
end if

#							device			version			file path			
open application			${device}		${version}		${app path}
		
#							language
select language				${language}