package com.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;

public class MyWxConfig extends WXPayConfig {

	private byte[] certData;

	public MyWxConfig() throws Exception {
		String certPath = "F:/奇迹活动/支付/apiclient_cert.pem";
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}

	@Override
	public String getAppID() {
		return "wx76595ccc5597a0d4";
	}

	@Override
	public String getMchID() {
		return "1451314602";
	}

	@Override
	public String getKey() {
		return "8002c6bc2c2d7b763e647dd15b4d1cf3";
	}

	@Override
	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	@Override
	public IWXPayDomain getWXPayDomain() {
		IWXPayDomain wxPayDomain = new IWXPayDomain() {
			
			public void report(String domain, long elapsedTimeMillis, Exception ex) {
			}
			
			public DomainInfo getDomain(WXPayConfig config) {
				// TODO Auto-generated method stub
				return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
			}
		};
		return wxPayDomain;
	}

}
