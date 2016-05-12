package applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Locale;

import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class applet extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1831202729826619341L;

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return super.isActive();
	}

	@Override
	public URL getDocumentBase() {
		// TODO Auto-generated method stub
		return super.getDocumentBase();
	}

	@Override
	public URL getCodeBase() {
		// TODO Auto-generated method stub
		return super.getCodeBase();
	}

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		return super.getParameter(name);
	}

	@Override
	public AppletContext getAppletContext() {
		// TODO Auto-generated method stub
		return super.getAppletContext();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
	}

	@Override
	public void resize(Dimension d) {
		// TODO Auto-generated method stub
		super.resize(d);
	}

	@Override
	public boolean isValidateRoot() {
		// TODO Auto-generated method stub
		return super.isValidateRoot();
	}

	@Override
	public void showStatus(String msg) {
		// TODO Auto-generated method stub
		super.showStatus(msg);
	}

	@Override
	public Image getImage(URL url) {
		// TODO Auto-generated method stub
		return super.getImage(url);
	}

	@Override
	public Image getImage(URL url, String name) {
		// TODO Auto-generated method stub
		return super.getImage(url, name);
	}

	@Override
	public AudioClip getAudioClip(URL url) {
		// TODO Auto-generated method stub
		return super.getAudioClip(url);
	}

	@Override
	public AudioClip getAudioClip(URL url, String name) {
		// TODO Auto-generated method stub
		return super.getAudioClip(url, name);
	}

	@Override
	public String getAppletInfo() {
		// TODO Auto-generated method stub
		return super.getAppletInfo();
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return super.getLocale();
	}

	@Override
	public String[][] getParameterInfo() {
		// TODO Auto-generated method stub
		return super.getParameterInfo();
	}

	@Override
	public void play(URL url) {
		// TODO Auto-generated method stub
		super.play(url);
	}

	@Override
	public void play(URL url, String name) {
		// TODO Auto-generated method stub
		super.play(url, name);
	}

	/**
	 * 该方法的目的是为你的applet提供所需的任何初始化。在Applet标记内的param标签被处理后调用该方法。
	 */
	@Override
	public void init() {
		JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);  
	    add(label);  
	}

	/**
	 * 浏览器调用init方法后，该方法被自动调用。每当用户从其他页面返回到包含Applet的页面时，则调用该方法。
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	/**
	 * 当用户从包含applet的页面移除的时候，该方法自动被调用。因此，可以在相同的applet中反复调用该方法。
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	/**
	 * 此方法仅当浏览器正常关闭时调用。因为applets只有在HTML网页上有效，所以你不应该在用户离开包含Applet的页面后遗漏任何资源.
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public AccessibleContext getAccessibleContext() {
		// TODO Auto-generated method stub
		return super.getAccessibleContext();
	}

	/**
	 * 该方法在start()方法之后立即被调用，或者在applet需要重绘在浏览器的时候调用。paint()方法实际上继承于java.awt。
	 */
	@Override
	public void paintComponents(Graphics g) {
		 g.drawString ("Hello World", 25, 50);
	}

}
