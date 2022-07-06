package THIGIUAKY;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Component;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.filechooser.FileSystemView;

import java.util.Date;
import java.util.List;

import java.io.*;

public class Bai1 {

	public static final String APP_TITLE = "Quản lý thư mục";

	private Desktop desktop;

	// FileSystemView là cổng vào JFileChooser của hệ thống tệp. Vì API tệp JDK1.1
	// không cho phép truy cập vào các
	// thông tin như phân vùng gốc, thông tin loại tệp hoặc các bit tệp ẩn, lớp này
	// được thiết kế để cung cấp càng nhiều thông
	// tin hệ thống tệp cụ thể
	private FileSystemView fileSystemView;

	private File currentFile;

	private JPanel gui;

	private JTree tree;
	private DefaultTreeModel treeModel;

	private JTable table;
	private JProgressBar progressBar;

	private FileTableModel fileTableModel;

	// Người nghe được thông báo khi giá trị lựa chọn danh sách thay đổi.
	private ListSelectionListener listSelectionListener;
	private boolean cellSizesSet = false;
	private int rowIconPadding = 6;

	private JButton openFile;

	public JFrame fame;

	public Container getGui() {

		gui = new JPanel(new BorderLayout(3, 3));
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));

		fileSystemView = FileSystemView.getFileSystemView();
		desktop = Desktop.getDesktop();
		/*
		 * Các hoạt động được hỗ trợ bao gồm:
		 * 
		 * khởi chạy trình duyệt mặc định của người dùng để hiển thị URI được chỉ định;
		 * khởi chạy ứng dụng thư mặc định của người dùng với mailtoURI tùy chọn ; khởi
		 * chạy một ứng dụng đã đăng ký để mở, chỉnh sửa hoặc in một tệp được chỉ định.
		 */

		JPanel detailView = new JPanel(new BorderLayout(3, 3));

		table = new JTable();
		// – JTable(): dùng để khởi tạo bảng với dữ liệu trống

		table.setAutoCreateRowSorter(true);
		// Sắp xếp và lọc bảng được quản lý bởi một đối tượng sắp xếp .

		table.setShowVerticalLines(true);

		listSelectionListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				// valueChanged(ListSelectionEvent e)
				// Được gọi bất cứ khi nào giá trị của lựa chọn thay đổi.
				int row = table.getSelectionModel().getLeadSelectionIndex();
				setFileDetails(((FileTableModel) table.getModel()).getFile(row));
			}
		};
		table.getSelectionModel().addListSelectionListener(listSelectionListener);
		JScrollPane tableScroll = new JScrollPane(table);
		Dimension d = tableScroll.getPreferredSize();
		// Dimension class là một phần của Java AWT. Nó chứa chiều cao và chiều rộng của
		// một thành phần theo số nguyên cũng như độ chính xác kép
		tableScroll.setPreferredSize(new Dimension((int) d.getWidth(), (int) d.getHeight() / 2));
		detailView.add(tableScroll, BorderLayout.CENTER);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		treeModel = new DefaultTreeModel(root);

		TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent tse) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getPath().getLastPathComponent();
				showChildren(node);
				setFileDetails((File) node.getUserObject());
			}
		};

		File[] roots = fileSystemView.getRoots();
		for (File fileSystemRoot : roots) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
			root.add(node);

			File[] files = fileSystemView.getFiles(fileSystemRoot, true);
			for (File file : files) {
				if (file.isDirectory()) {
					node.add(new DefaultMutableTreeNode(file));
				}
			}
			//
		}

		tree = new JTree(treeModel);
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(treeSelectionListener);
		tree.setCellRenderer(new FileTreeCellRenderer());
		tree.expandRow(0);
		JScrollPane treeScroll = new JScrollPane(tree);

		tree.setVisibleRowCount(15);

		Dimension preferredSize = treeScroll.getPreferredSize();
		Dimension widePreferred = new Dimension(200, (int) preferredSize.getHeight());
		treeScroll.setPreferredSize(widePreferred);

		JPanel fileMainDetails = new JPanel(new BorderLayout(4, 2));
		fileMainDetails.setBorder(new EmptyBorder(0, 6, 0, 6));

		JPanel fileDetailsLabels = new JPanel(new GridLayout(0, 1, 2, 2));
		fileMainDetails.add(fileDetailsLabels, BorderLayout.WEST);

		JPanel fileDetailsValues = new JPanel(new GridLayout(0, 1, 2, 2));
		fileMainDetails.add(fileDetailsValues, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar();

		toolBar.setFloatable(false);

		openFile = new JButton("Open");
		openFile.setMnemonic('o');

		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					desktop.open(currentFile);
					// Khởi chạy ứng dụng liên quan để mở tệp.
					// Nếu tệp được chỉ định là một thư mục, trình quản lý tệp của nền tảng hiện tại
					// được khởi chạy để mở tệp.
				} catch (Throwable t) {
					System.out.println("Lỗi");
				}
				gui.repaint();
			}
		});
		toolBar.add(openFile);

		JPanel fileView = new JPanel(new BorderLayout(3, 3));

		fileView.add(toolBar, BorderLayout.NORTH);
		fileView.add(fileMainDetails, BorderLayout.CENTER);

		detailView.add(fileView, BorderLayout.SOUTH);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, detailView);
		gui.add(splitPane, BorderLayout.CENTER);

		JPanel simpleOutput = new JPanel(new BorderLayout(3, 3));
		progressBar = new JProgressBar();
		simpleOutput.add(progressBar, BorderLayout.EAST);
		progressBar.setVisible(false);

		gui.add(simpleOutput, BorderLayout.SOUTH);

		return gui;
	}

	public void showRootFile() {

		tree.setSelectionInterval(0, 0);
	}

	private void setTableData(final File[] files) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (fileTableModel == null) {
					fileTableModel = new FileTableModel();
					table.setModel(fileTableModel);
				}
				table.getSelectionModel().removeListSelectionListener(listSelectionListener);
				fileTableModel.setFiles(files);
				table.getSelectionModel().addListSelectionListener(listSelectionListener);
				if (!cellSizesSet) {
					Icon icon = fileSystemView.getSystemIcon(files[0]);

					table.setRowHeight(icon.getIconHeight() + rowIconPadding);

					setColumnWidth(0, -1);
					setColumnWidth(3, 60);
					table.getColumnModel().getColumn(3).setMaxWidth(120);
					setColumnWidth(4, -1);

					cellSizesSet = true;
				}
			}
		});
	}

	private void setColumnWidth(int column, int width) {
		TableColumn tableColumn = table.getColumnModel().getColumn(column);
		if (width < 0) {

			JLabel label = new JLabel((String) tableColumn.getHeaderValue());
			Dimension preferred = label.getPreferredSize();

			width = (int) preferred.getWidth() + 14;
		}
		tableColumn.setPreferredWidth(width);
		tableColumn.setMaxWidth(width);
	}

	private void showChildren(final DefaultMutableTreeNode node) {
		tree.setEnabled(false);
		progressBar.setVisible(true);
		progressBar.setIndeterminate(true);

		// Nó được sử dụng để thực hiện các tác vụ tương tác GUI dài trong một luồng
		// nền. Trong khi phát triển các ứng dụng,
		// đôi khi GUI bị treo khi nó đang cố thực hiện một số nhiệm vụ lớn hoặc dài. Độ
		// trễ này là một nút cổ chai lớn.
		// Với mục đích như vậy, swingworker được phát triển để lên lịch thực hiện tác
		// vụ dài này trên một luồng khác trong khi GUI vẫn đáp ứng.

		SwingWorker<Void, File> worker = new SwingWorker<Void, File>() {
			@Override
			public Void doInBackground() {
				File file = (File) node.getUserObject();
				if (file.isDirectory()) {
					File[] files = fileSystemView.getFiles(file, true); // !!
					if (node.isLeaf()) {
						for (File child : files) {
							if (child.isDirectory()) {
								publish(child);
							}
						}
					}
					setTableData(files);
				}
				return null;
			}

			@Override
			protected void process(List<File> chunks) {
				for (File child : chunks) {
					node.add(new DefaultMutableTreeNode(child));
				}
			}

			@Override
			protected void done() {
				progressBar.setIndeterminate(false);
				progressBar.setVisible(false);
				tree.setEnabled(true);
			}
		};
		worker.execute();
	}

	private void setFileDetails(File file) {
		currentFile = file;

		JFrame f = (JFrame) gui.getTopLevelAncestor();
		if (f != null) {
			f.setTitle(APP_TITLE + " :: " + fileSystemView.getSystemDisplayName(file)); // lấy tên của thư mục đang chọn
		}

		gui.repaint();
	}

	public static void run() {

		JFrame f = new JFrame(APP_TITLE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Bai1 fileManager = new Bai1();
		f.setContentPane(fileManager.getGui());

		f.pack();

		f.setVisible(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fileManager.showRootFile();
	}

	public static void main(String[] args) {
		run();

	}

	class FileTableModel extends AbstractTableModel {

		private File[] files;
		private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
		private String[] columns = { "Icon", "File", "Path/name", "Size", "Last Modified" };

		FileTableModel() {
			this(new File[0]);
		}

		FileTableModel(File[] files) {
			this.files = files;
		}

		public Object getValueAt(int row, int column) {
			File file = files[row];
			switch (column) {
			case 0:
				return fileSystemView.getSystemIcon(file);
			case 1:
				return fileSystemView.getSystemDisplayName(file);
			case 2:
				return file.getPath();
			case 3:
				return file.length();
			case 4:
				return file.lastModified();

			default:
				System.err.println("Logic Error");
			}
			return "";
		}

		public int getColumnCount() {
			return columns.length;
		}

		public Class<?> getColumnClass(int column) {
			switch (column) {
			case 0:
				return ImageIcon.class;
			case 3:
				return Long.class;
			case 4:
				return Date.class;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				return Boolean.class;
			}
			return String.class;
		}

		public String getColumnName(int column) {
			return columns[column];
		}

		public int getRowCount() {
			return files.length;
		}

		public File getFile(int row) {
			return files[row];
		}

		public void setFiles(File[] files) {
			this.files = files;
			fireTableDataChanged();
		}
	}

	class FileTreeCellRenderer extends DefaultTreeCellRenderer {

		private FileSystemView fileSystemView;

		private JLabel label;

		FileTreeCellRenderer() {
			label = new JLabel();
			label.setOpaque(true);
			fileSystemView = FileSystemView.getFileSystemView();
		}

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
				boolean leaf, int row, boolean hasFocus) {

			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			File file = (File) node.getUserObject();
			label.setIcon(fileSystemView.getSystemIcon(file));
			label.setText(fileSystemView.getSystemDisplayName(file));
			label.setToolTipText(file.getPath());

			if (selected) {
				label.setBackground(backgroundSelectionColor);
				label.setForeground(textSelectionColor);
			} else {
				label.setBackground(backgroundNonSelectionColor);
				label.setForeground(textNonSelectionColor);
			}

			return label;
		}
	}
}