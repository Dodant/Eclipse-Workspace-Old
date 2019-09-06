import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyAlbum extends JFrame {
	JTabbedPane tab = new JTabbedPane();
	JCheckBox likeBtn;
	JTextArea txtA;

	public MyAlbum() {
		setTitle("MyAlbum");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		centerPanel.setBackground(Color.lightGray);

		tab.setPreferredSize(new Dimension(650, 380));
		tab.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int index = tab.getSelectedIndex();
				ImagePanel p = (ImagePanel) tab.getComponentAt(index);
				if (p.getPointer() > -1)
					likeBtn.setSelected(p.getLikeFlag());
			}
		});
		centerPanel.add(tab);

		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu custom = new JMenu("Custom");
		JMenuItem addImg = new JMenuItem("Add Image");
		JMenuItem remImg = new JMenuItem("Remove Image");
		JMenuItem addAlbum = new JMenuItem("Create Album");
		JMenuItem remAlbum = new JMenuItem("Remove Album");
		JMenuItem colorTheme = new JMenuItem("Color Theme");
		JMenuItem exit = new JMenuItem("Exit");

		file.add(addImg);
		file.add(remImg);
		file.add(addAlbum);
		file.add(remAlbum);
		file.addSeparator();
		file.add(exit);
		custom.add(colorTheme);
		mb.add(file);
		mb.add(custom);
		setJMenuBar(mb);

		colorTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setBackground(JColorChooser.showDialog(null, "색상 선택", Color.lightGray));
			}
		});

		JButton leftBtn = new JButton("<<<");
		JButton rightBtn = new JButton(">>>");
		ImageIcon deselectedStar = new ImageIcon("DeselectedStar.png");
		ImageIcon selectedStar = new ImageIcon("SelectedStar.png");
		likeBtn = new JCheckBox(deselectedStar, false);
		likeBtn.setSelectedIcon(selectedStar);
		txtA = new JTextArea(3, 15);
		txtA.setLineWrap(true);
		txtA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ENTER) {
					String str = txtA.getText();
					int index = tab.getSelectedIndex();
					String albumName = tab.getTitleAt(index);
					ImagePanel p = (ImagePanel) tab.getComponentAt(index);
					int pointer = p.getPointer();
					FileOutputStream fos;
					File memof = new File("memo/" + albumName + "/" + "memo" + pointer + ".txt");
					try {
						fos = new FileOutputStream(memof);
						fos.write(str.getBytes());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		JScrollPane scroll = new JScrollPane(txtA);
		southPanel.add(leftBtn);
		southPanel.add(scroll);
		southPanel.add(likeBtn);
		southPanel.add(rightBtn);

		initializing();

		addImg.addActionListener(new AddImageListener());
		remImg.addActionListener(new RemImageListener());
		addAlbum.addActionListener(new AddAlbumListener());
		remAlbum.addActionListener(new RemAlbumListener());
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		leftBtn.addActionListener(new RLbtnListener());
		rightBtn.addActionListener(new RLbtnListener());
		likeBtn.addMouseListener(new LikeBtnListener());

		setSize(700, 520);
		setVisible(true);
	}

	private void initializing() {
		File imgFavor = new File("images/즐겨찾기");
		File memoFavor = new File("memo/즐겨찾기");
		File likeFlagFavor = new File("likeFlag/즐겨찾기");
		if (!memoFavor.exists())
			memoFavor.mkdirs();
		if (!likeFlagFavor.exists())
			likeFlagFavor.mkdirs();
		if (imgFavor.exists()) {
			ImagePanel imagePane = new ImagePanel();
			tab.addTab("즐겨찾기", imagePane);
			imagePane.initPanel("즐겨찾기");
		} else {
			imgFavor.mkdirs();
			ImagePanel imagePane = new ImagePanel();
			tab.addTab("즐겨찾기", imagePane);
			imagePane.initPanel("즐겨찾기");
			return;
		}
		File[] F = new File("images/").listFiles();
		for (int i = 0; i < F.length; i++) {
			if (F[i].isDirectory()) {
				String albumName = F[i].getName();
				if (albumName.compareTo("즐겨찾기") == 0)
					continue;
				ImagePanel imagePane = new ImagePanel();
				tab.addTab(albumName, imagePane);
				imagePane.initPanel(albumName);
			}
		}
	}

	class ImagePanel extends JPanel {
		private Image img;
		private Vector<Image> imgV;
		private Vector<String> memo;
		private Vector<Boolean> likeFlag;
		public int length;
		private int pointer;

		public ImagePanel() {
			img = null;
			imgV = new Vector<Image>();
			memo = new Vector<String>();
			likeFlag = new Vector<Boolean>();
			length = 0;
			pointer = -1;
		}

		public void initPanel(String albumName) {
			File[] imgF = new File("images/" + albumName).listFiles();
			File[] memoF = new File("memo/" + albumName).listFiles();
			File[] likeFlagF = new File("likeFlag/" + albumName).listFiles();
			if (imgF != null) {
				for (int i = 0; i < imgF.length; i++) {
					length++;
					pointer++;
					imgF[i].renameTo(new File("images/" + albumName + "/" + "pic" + pointer + ".jpg"));
					ImageIcon icon = new ImageIcon(imgF[i].getPath());
					Image img = icon.getImage();
					imgV.add(img);

					FileInputStream fis;
					FileOutputStream fos;
					try {
						if (memoF != null && i < memoF.length) {
							fis = new FileInputStream(memoF[i]);
							String mem = new String(fis.readAllBytes());
							memo.add(mem);
						} else {
							memo.add("");
							File file = new File("memo/" + albumName + "/" + "memo" + pointer + ".txt");
							file.createNewFile();
							fos = new FileOutputStream(file);
							String str = "";
							memo.add(str);
							fos.write(str.getBytes());
							fos.close();
						}
						if (likeFlagF != null && i < likeFlagF.length) {
							fis = new FileInputStream(likeFlagF[i]);
							String flag = new String(fis.readAllBytes());
							likeFlag.add(Boolean.valueOf(flag));
						} else {
							File file = new File("likeFlag/" + albumName + "/" + "flag" + pointer + ".txt");
							file.createNewFile();
							fos = new FileOutputStream(file);
							String str;
							if (albumName == "즐겨찾기")
								str = "true";
							else
								str = "false";
							likeFlag.add(Boolean.valueOf(str));
							fos.write(str.getBytes());
							fos.close();

						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (imgF.length > 0) {
					setImage(imgV.lastElement());
				}
				if (albumName == "즐겨찾기" && imgF.length > 0) {
					txtA.setText(memo.lastElement());
					likeBtn.setSelected(likeFlag.lastElement());
				}
			}
		}

		public void setImage(Image img) {
			this.img = img;
			repaint();
		}

		public void addElement(Image img, String memo, Boolean likeFlag) {
			imgV.add(img);
			this.memo.add(memo);
			this.likeFlag.add(likeFlag);
			length++;
			pointer++;
			setImage(img);
			txtA.setText(memo);
		}

		public void removeElement(int index) {
			imgV.remove(index);
			memo.remove(index);
			likeFlag.remove(index);
			length--;
			pointer--;
			if (pointer > -1) {
				setImage(imgV.elementAt(pointer));
				txtA.setText(memo.elementAt(pointer));
				likeBtn.setSelected(!likeFlag.elementAt(pointer));
			} else {
				setImage(null);
				txtA.setText("");
				likeBtn.setSelected(!false);
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}

		public void nextImg() {
			if (length > 0) {
				if (pointer < length - 1)
					pointer++;
				else
					pointer = 0;
				setImage(imgV.elementAt(pointer));
				txtA.setText(memo.elementAt(pointer));
				likeBtn.setSelected(likeFlag.elementAt(pointer));
			} else {
				JOptionPane.showMessageDialog(null, "이미지가 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}

		public void previousImg() {
			if (length > 0) {
				if (pointer > 0)
					pointer--;
				else
					pointer = length - 1;
				setImage(imgV.elementAt(pointer));
				txtA.setText(memo.elementAt(pointer));
				likeBtn.setSelected(likeFlag.elementAt(pointer));
			} else {
				JOptionPane.showMessageDialog(null, "이미지가 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}

		public void addImg() {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG&GIF Images", "jpg", "gif", "png");
			chooser.setFileFilter(filter);

			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			length++;
			pointer++;

			String path = chooser.getSelectedFile().getPath();
			ImageIcon icon = new ImageIcon(path);
			Image img = icon.getImage();

			int index = tab.getSelectedIndex();
			String s = tab.getTitleAt(index);
			BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			g.drawImage(icon.getImage(), 0, 0, 400, 400, null);
			try {
				File file = new File("images/" + s + "/" + "pic" + pointer + ".jpg");
				ImageIO.write(image, "jpg", file);
				imgV.add(img);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				FileOutputStream fos;
				File file = new File("memo/" + s + "/" + "memo" + pointer + ".txt");
				file.createNewFile();
				fos = new FileOutputStream(file);
				String str = "";
				memo.add(str);
				fos.write(str.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				FileOutputStream fos;
				File file = new File("likeFlag/" + s + "/" + "flag" + pointer + ".txt");
				file.createNewFile();
				fos = new FileOutputStream(file);
				String str;
				if (s == "즐겨찾기")
					str = "true";
				else
					str = "false";
				likeFlag.add(Boolean.valueOf(str));
				fos.write(str.getBytes());
				fos.close();
				likeBtn.setSelected(Boolean.valueOf(str));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setImage(img);
		}

		public void removeImg() {
			if (pointer > -1) {
				int index = tab.getSelectedIndex();
				String s = tab.getTitleAt(index);
				if (index == 0) {
					JOptionPane.showMessageDialog(null, "이미지를 삭제하려면 원래 이미지에서 즐겨찾기를 해제해주세요", "경고",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				File imgF = new File("images/" + s);
				File memoF = new File("memo/" + s);
				File flagF = new File("likeFlag/" + s);
				File[] imgFavor = imgF.listFiles();
				File[] memoFavor = memoF.listFiles();
				File[] flagFavor = flagF.listFiles();

				imgFavor[pointer].delete();
				memoFavor[pointer].delete();
				flagFavor[pointer].delete();
				imgFavor = imgF.listFiles();
				memoFavor = memoF.listFiles();
				flagFavor = flagF.listFiles();
				for (int j = pointer; j < imgFavor.length; j++) {
					imgFavor[j].renameTo(new File("images/" + s + "/pic" + j + ".jpg"));
					memoFavor[j].renameTo(new File("memo/" + s + "/memo" + j + ".jpg"));
					flagFavor[j].renameTo(new File("likeFlag/" + s + "/flag" + j + ".jpg"));
				}
				imgV.remove(pointer);
				memo.remove(pointer);
				likeFlag.remove(pointer);
				length--;
				pointer--;
				if (pointer > -1) {
					setImage(imgV.elementAt(pointer));
					txtA.setText(memo.elementAt(pointer));
					likeBtn.setSelected(likeFlag.elementAt(pointer));
				} else {
					setImage(null);
					txtA.setText("");
					likeBtn.setSelected(false);
				}
			} else {
				JOptionPane.showMessageDialog(null, "삭제할 이미지가 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}

		public String getMemo() {
			return memo.elementAt(pointer);
		}

		public void setMemo(String memo) {
			this.memo.setElementAt(memo, pointer);
		}

		public boolean getLikeFlag() {
			return likeFlag.elementAt(pointer);
		}

		public void setLikeFlag(boolean likeFlag) {
			this.likeFlag.setElementAt(likeFlag, pointer);
			FileOutputStream fos;
			int index = tab.getSelectedIndex();
			String s = tab.getTitleAt(index);
			File file = new File("likeFlag/" + s + "/" + "flag" + pointer + ".txt");
			String str = String.valueOf(likeFlag);
			try {
				fos = new FileOutputStream(file);
				fos.write(str.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (s == "즐겨찾기")
				str = "true";
			else
				str = "false";

		}

		public int getPointer() {
			return pointer;
		}

		public Image getImg() {
			return imgV.elementAt(pointer);
		}

		public Vector<Image> getImgV() {
			return imgV;
		}

		public Vector<String> getMemoV() {
			return memo;
		}

		public Vector<Boolean> getLikeFlagV() {
			return likeFlag;
		}
	}

	class AddImageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			int index = tab.getSelectedIndex();
			ImagePanel p = (ImagePanel) tab.getComponentAt(index);
			p.addImg();
		}
	}

	class RemImageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = tab.getSelectedIndex();
			ImagePanel p = (ImagePanel) tab.getComponentAt(index);
			p.removeImg();
		}
	}

	class AddAlbumListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String album_name = JOptionPane.showInputDialog("Create Album");
			if (album_name == null) {
				return;
			}
			tab.addTab(album_name, new ImagePanel());
			String path = "images/" + album_name;
			File f = new File(path);
			f.mkdir();
			path = "memo/" + album_name;
			f = new File(path);
			f.mkdir();
			path = "likeFlag/" + album_name;
			f = new File(path);
			f.mkdir();
		}
	}

	class RemAlbumListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String rem_name = JOptionPane.showInputDialog("remove Album");
			for (int i = 1; i < tab.getTabCount(); i++) {
				if (tab.getTitleAt(i).equals(rem_name)) {
					tab.remove(i);
					File file = new File("images/" + rem_name);
					if (file.exists()) {
						if (file.isDirectory()) {
							File[] files = file.listFiles();
							for (int j = 0; j < files.length; j++) {
								files[j].delete();
							}
						}
						file.delete();
					} else {
						System.out.println("이미지 파일이 존재하지 않습니다.");
					}
					file = new File("memo/" + rem_name);
					if (file.exists()) {
						if (file.isDirectory()) {
							File[] files = file.listFiles();
							for (int j = 0; j < files.length; j++) {
								files[j].delete();
							}
						}
						file.delete();
					} else {
						System.out.println("메모 파일이 존재하지 않습니다.");
					}
					file = new File("likeFlag/" + rem_name);
					if (file.exists()) {
						if (file.isDirectory()) {
							File[] files = file.listFiles();
							for (int j = 0; j < files.length; j++) {
								files[j].delete();
							}
						}
						file.delete();
					} else {
						System.out.println("플래그 파일이 존재하지 않습니다.");
					}
				}
			}
		}
	}

	class RLbtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			int index = tab.getSelectedIndex();
			ImagePanel p = (ImagePanel) tab.getComponentAt(index);
			if (btn.getText() == "<<<") {
				p.previousImg();
			} else if (btn.getText() == ">>>") {
				p.nextImg();
			}
		}
	}

	class LikeBtnListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			if (!likeBtn.isSelected()) {
				int index = tab.getSelectedIndex();
				if (index == 0)
					return;
				ImagePanel p = (ImagePanel) tab.getComponentAt(index);
				if (p.getPointer() < 0) {
					JOptionPane.showMessageDialog(null, "이미지가 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				p.setLikeFlag(!likeBtn.isSelected());
				p.setMemo(txtA.getText());
				File[] imgFavor = new File("images/즐겨찾기").listFiles();
				File[] memoFavor = new File("memo/즐겨찾기").listFiles();
				File[] flagFavor = new File("likeFlag/즐겨찾기").listFiles();
				ImagePanel fPane = (ImagePanel) tab.getComponent(0);
				fPane.addElement(p.getImg(), p.getMemo(), !likeBtn.isSelected());
				BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
				Graphics g = image.getGraphics();
				g.drawImage(p.getImg(), 0, 0, 400, 400, null);
				File file = new File("images/즐겨찾기/pic" + imgFavor.length + ".jpg");
				try {
					ImageIO.write(image, "jpg", file);
					FileOutputStream fos;
					file = new File("memo/즐겨찾기/memo" + memoFavor.length + ".txt");
					file.createNewFile();
					fos = new FileOutputStream(file);
					String str = p.getMemo();
					fos.write(str.getBytes());
					fos.close();
					file = new File("likeFlag/즐겨찾기/flag" + flagFavor.length + ".txt");
					file.createNewFile();
					fos = new FileOutputStream(file);
					str = String.valueOf(p.getLikeFlag());
					fos.write(str.getBytes());
					fos.close();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				int index = tab.getSelectedIndex();
				ImagePanel p = (ImagePanel) tab.getComponentAt(index);
				ImagePanel favorite = (ImagePanel) tab.getComponentAt(0);

				File imgF = new File("images/즐겨찾기");
				File memoF = new File("memo/즐겨찾기");
				File flagF = new File("likeFlag/즐겨찾기");
				File[] imgFavor = imgF.listFiles();
				File[] memoFavor = memoF.listFiles();
				File[] flagFavor = flagF.listFiles();
				if (index == 0) {
					if (favorite.getPointer() > -1)
						likeBtn.setSelected(false);
					else
						likeBtn.setSelected(true);
					return;
				}

				p.setLikeFlag(!likeBtn.isSelected());
				Image img = p.getImg();
				Vector<Image> imgV = favorite.getImgV();
				if (imgV.size() > 0) {
					for (int i = 0; i < imgV.size(); i++) {
						if (new ImageIcon(img).getImageObserver() == new ImageIcon(imgV.elementAt(i))
								.getImageObserver()) {
							imgFavor[i].delete();
							memoFavor[i].delete();
							flagFavor[i].delete();
							favorite.removeElement(i);
							imgFavor = imgF.listFiles();
							memoFavor = memoF.listFiles();
							flagFavor = flagF.listFiles();
							for (int j = i; j < imgFavor.length; j++) {
								imgFavor[j].renameTo(new File("images/즐겨찾기/pic" + j + ".jpg"));
								memoFavor[j].renameTo(new File("memo/즐겨찾기/memo" + j + ".jpg"));
								flagFavor[j].renameTo(new File("likeFlag/즐겨찾기/flag" + j + ".jpg"));
							}
						}
					}
				}
				tab.revalidate();
				tab.repaint();
			}
		}
	}

	public static void main(String[] args) {
		new MyAlbum();
	}
}