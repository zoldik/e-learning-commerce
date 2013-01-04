<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<div class="container-fluid">
<div class="span6 offset3">
	<s:form action="registerStudent" theme="bootstrap" cssClass="form-horizontal">
		<s:push value="student">
			<h4>Informations du compte</h4>
			<s:textfield name="username" label="Nom d'utilisateur"
				tooltip="Enter your username here" />
			<s:textfield name="email" key="email.label" tooltip="Enter your email" />
			<s:password name="password" key="password.label"
				tooltip="Enter your password" />
			<s:password name="confirmPassword" key="Confirmation mot de passe"
				tooltip="Veuillez confirmer votre mot de passe" />
			<div class="separator"></div>
			<h4>Informations personnelles</h4>
			<s:textfield name="cin" label="Carte d'identité nationale" 
				tooltip="Veuillez indiquer votre carte d'identité nationale"/>
			<s:textfield name="firstName" key="firstname.label" 
				tooltip="Enter your firstname here"/>
			<s:textfield name="lastName" key="lastname.label" 
				tooltip="Enter your lastname here" />
			<s:radio tooltip="choissez parmi ces types"
			label="Etat civil" name="situation"
			list="#{'celibataire':'célibataire','married':'marié/mariée','veuf':'veuf/veuve'}" value="1" />
			<sj:datepicker name="birthday" id="birthday" changeYear="true" 
				parentTheme="bootstrap" displayFormat="dd/mm/yy" label="Date de naissance"
				tooltip="Indiquer votre date de naissance" minDate="-50y 0m 0d"  />
			<s:select list="#{'homme' : 'homme' , 'femme' : 'femme' }"headerValue="Je suis un/une..."
			headerKey="-1" name="sexe" label="Sexe"
			tooltip="Veuillez indiquer votre sexe" />
			<s:textfield name="phone" label="Téléphone mobile" 
				tooltip="Veuillez indiquer votre numéro de téléphone" />
			<s:textfield name="fixedPhone" label="Téléphone fixe" 
				tooltip="Veuillez indiquer votre numéro de téléphone fixe" />
			<s:select list="gouvernorateSelect" name="gouvernorate" label="Gouvernorate"
			tooltip="Veuillez choisir votre gouvernorat"/>
			<s:textfield name="adress" key="adress.label" 
				tooltip="Enter your adress here" />			
			<s:textfield name="zipCode" label="Code postal" 
				tooltip="Veuillez indiquer votre code postal" />	
			<s:select list="formationSelect" name="formations" disabled="true" label="Formation"/>
			<s:select list="affiliateSelect" name="" disabled="true" label="Filiale"/>
		</s:push>
		<s:submit cssClass="btn btn-inverse offset7"
			label="terminer" />
	</s:form>
</div>
</div>