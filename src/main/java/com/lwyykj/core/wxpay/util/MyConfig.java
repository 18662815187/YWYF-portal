package com.lwyykj.core.wxpay.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;

public class MyConfig implements WXPayConfig {
	private byte[] certData;

	public MyConfig() throws Exception {
		String certPath = "D://path/to/apiclient_cert.p12";
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}

	@Override
	public String getAppID() {
		return "wx78edd96baf6e1873";
	}

	@Override
	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
	}

	@Override
	public int getHttpConnectTimeoutMs() {
		return 8000;
	}

	@Override
	public int getHttpReadTimeoutMs() {
		return 10000;
	}

	@Override
	public String getKey() {
		return "c15c86cd3b0abd5e75669eb1254040a1";
	}

	@Override
	public String getMchID() {
		return "1501213721";
	}

}
