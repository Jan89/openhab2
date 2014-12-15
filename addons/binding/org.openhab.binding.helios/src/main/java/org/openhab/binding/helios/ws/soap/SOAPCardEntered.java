/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.helios.ws.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.openhab.binding.helios.handler.HeliosHandler27;

/**
 * Helios SOAP Protocol Message
 * 
 * @author Karel Goderis - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data", namespace = HeliosHandler27.HELIOS_URI)
public class SOAPCardEntered extends SOAPDataField {

	@XmlElement(name = "Card", namespace = HeliosHandler27.HELIOS_URI)
	protected String card;

	@XmlElement(name = "Valid", namespace = HeliosHandler27.HELIOS_URI)
	protected String valid;

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}
