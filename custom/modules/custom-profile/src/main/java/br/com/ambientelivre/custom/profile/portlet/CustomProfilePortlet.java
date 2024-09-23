package br.com.ambientelivre.custom.profile.portlet;

import br.com.ambientelivre.custom.profile.constants.CustomProfilePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
/**
 * @author ambientelivre
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.admin",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CustomProfile",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomProfilePortletKeys.CUSTOMPROFILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomProfilePortlet extends MVCPortlet {   
}