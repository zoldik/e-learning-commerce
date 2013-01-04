<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<set var="classTab" value=""/>

<div class="tabbable tabs-left">
  <ul class="nav nav-tabs">
   	<s:iterator value="affiliates">
   		<s:set var="affiliateId" value="id"/>
   		<s:if test="%{#affiliateId==1}">
   			<s:set var="classTab">active</s:set>
   		</s:if>
   		<s:else>
   			<s:set var="classTab" value=""/>
   		</s:else>
   		<li class="<s:property value="#classTab"/>">
   			<a href="#affiliate<s:property value="id"/>" data-toogle="tab"><s:property value="name"/></a>
   		</li>
   	</s:iterator>
  </ul>
  <div class="tab-content">
    	<s:iterator value="affiliates" >
    		<s:set var="affiliateId" value="id"/>
	   		<s:if test="%{#affiliateId==1}">
	   			<s:set var="classTab">active</s:set>
	   		</s:if>
	   		<s:else>
	   			<s:set var="classTab" value=""/>
	   		</s:else>
    		<div class="tab-pane <s:property value="#classTab"/>" id="affiliate<s:property value="id"/>">
    			<table class="table table-bordered">
    				<thead>
    					<tr>
    						<th>	
    							Nom de la formation
    						</th>
    						<th>
    							Date début
    						</th>
    						<th>
    							Date fin
    						</th>
    						<th>
    							Abonnement
    						</th>
    					</tr>
    				</thead>
    				<tbody>
    					<s:iterator value="formations">
    						<tr>
    							<td>
    								<s:property value="name"/>
    							</td>
    							<td>
    								<s:property value="startDate"/>
    							</td>
    							<td>
    								<s:property value="endDate"/>
    							</td>
    							<td>
    								<s:url var="registerURL" namespace="/pages" method="input" action="registerStudent">
    									<s:param name="id" value="%{id}"/>
    								</s:url>
    								<s:a href="%{registerURL}" cssClass="btn btn-primary">
    								 s'adhérer
    								</s:a>
    							</td>
    						</tr>
    					</s:iterator>
    				</tbody>
    			</table>
    		</div>
    	</s:iterator>	
  </div>
</div>