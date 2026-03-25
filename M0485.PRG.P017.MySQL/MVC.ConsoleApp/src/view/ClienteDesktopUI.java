package view;

import model.domain.Cliente;
import model.service.ClienteService;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;

public class ClienteDesktopUI extends JFrame {

    private static final Color BG_DARK       = new Color(220, 235, 250);
    private static final Color BG_PANEL      = new Color(230, 240, 255);
    private static final Color BG_CARD       = new Color(200, 220, 245);
    private static final Color ACCENT_SKY    = new Color(160, 190, 220);
    private static final Color ACCENT_PINK   = new Color(220, 160, 180);
    private static final Color ACCENT_SOFT   = new Color(190, 210, 235);
    private static final Color SUCCESS_MINT  = new Color(180, 230, 200);
    private static final Color BTN_EDIT_BG   = new Color(180, 210, 240);
    private static final Color BTN_DELETE_BG = new Color(240, 180, 180);
    private static final Color TEXT_DARK     = new Color(60, 70, 80);
    private static final Color TEXT_DIM      = new Color(110, 120, 130);
    private static final Color ROW_ALT       = new Color(225, 238, 252);

    private static final Font FONT_TITLE  = new Font("Segoe UI", Font.BOLD, 22);
    private static final Font FONT_HEADER = new Font("Segoe UI", Font.BOLD, 13);
    private static final Font FONT_BODY   = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FONT_SMALL  = new Font("Segoe UI", Font.PLAIN, 12);
    private static final Font FONT_BTN    = new Font("Segoe UI", Font.BOLD, 12);
    private static final Font FONT_CELL   = new Font("Segoe UI", Font.PLAIN, 13);

    private static ClienteDesktopUI instance = null;

    public static ClienteDesktopUI getInstance(ClienteService clienteService) {
        if (instance == null) {
            instance = new ClienteDesktopUI(clienteService);
        }
        return instance;
    }

    private final ClienteService clienteService;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField searchField;
    private JComboBox<String> searchTypeCombo;

    private ClienteDesktopUI(ClienteService clienteService) {
        this.clienteService = clienteService;
        setTitle(" Gestión de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 600));
        setSize(1050, 680);
        setLocationRelativeTo(null);

        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
        catch (Exception ignored) {}

        getContentPane().setBackground(BG_DARK);
        setLayout(new BorderLayout(0, 0));

        add(buildHeader(), BorderLayout.NORTH);
        add(buildCenter(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);

        refrescarTabla(clienteService.findAll());
    }

    private JPanel buildHeader() {
        JPanel header = new JPanel(new BorderLayout(16, 0));
        header.setBackground(BG_PANEL);
        header.setBorder(new CompoundBorder(
            new MatteBorder(0, 0, 2, 0, ACCENT_SKY),
            new EmptyBorder(14, 20, 14, 20)
        ));

        JLabel title = new JLabel(" Gestión de Clientes ");
        title.setFont(FONT_TITLE);
        title.setForeground(TEXT_DARK);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        searchPanel.setOpaque(false);

        searchTypeCombo = new JComboBox<>(new String[]{"Todos", "Por ID", "Por Razón Social"});
        styleCombo(searchTypeCombo);
        searchTypeCombo.addActionListener(e -> onSearchTypeChanged());

        searchField = new JTextField(18);
        styleTextField(searchField);
        searchField.setVisible(false);
        searchField.addActionListener(e -> ejecutarBusqueda());

        JButton btnBuscar = buildIconButton("Buscar", TEXT_DARK, BTN_EDIT_BG);
        btnBuscar.addActionListener(e -> ejecutarBusqueda());

        JButton btnAlta = buildIconButton("+ Dar de Alta", TEXT_DARK, SUCCESS_MINT);
        btnAlta.addActionListener(e -> abrirFormulario(FormMode.ALTA, null));

        searchPanel.add(searchTypeCombo);
        searchPanel.add(searchField);
        searchPanel.add(btnBuscar);
        searchPanel.add(Box.createHorizontalStrut(12));
        searchPanel.add(btnAlta);

        header.add(title, BorderLayout.WEST);
        header.add(searchPanel, BorderLayout.EAST);
        return header;
    }

    private JScrollPane buildCenter() {
        String[] cols = {"#", "Razón Social", "Nombre Comercial", "Límite Crédito", "Modificar", "Eliminar"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override 
            public boolean isCellEditable(int row, int col) {
                return col == 4 || col == 5; 
            }
            @Override public Class<?> getColumnClass(int col) { return String.class; }
        };

        table = new JTable(tableModel);
        table.setBackground(BG_DARK);
        table.setForeground(TEXT_DARK);
        table.setFont(FONT_CELL);
        table.setRowHeight(40);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(ACCENT_SOFT);
        table.setSelectionForeground(TEXT_DARK);
        table.setFocusable(false);

        JTableHeader th = table.getTableHeader();
        th.setBackground(BG_CARD);
        th.setForeground(TEXT_DARK);
        th.setFont(FONT_HEADER);
        th.setReorderingAllowed(false);
        th.setBorder(new MatteBorder(0, 0, 2, 0, ACCENT_SKY));
        th.setPreferredSize(new Dimension(th.getWidth(), 44));

        TableColumnModel cm = table.getColumnModel();
        cm.getColumn(0).setPreferredWidth(50);
        cm.getColumn(0).setMaxWidth(70);
        cm.getColumn(1).setPreferredWidth(260);
        cm.getColumn(2).setPreferredWidth(220);
        cm.getColumn(3).setPreferredWidth(130);
        cm.getColumn(4).setPreferredWidth(100);
        cm.getColumn(5).setPreferredWidth(100);

        cm.getColumn(4).setCellRenderer(new ButtonRenderer("✎ Editar", BTN_EDIT_BG));
        cm.getColumn(4).setCellEditor(new ButtonEditor("✎ Editar", BTN_EDIT_BG, () -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                clienteService.findById(id).ifPresent(c -> abrirFormulario(FormMode.MODIFICAR, c));
            }
        }));

        cm.getColumn(5).setCellRenderer(new ButtonRenderer("✘ Borrar", BTN_DELETE_BG));
        cm.getColumn(5).setCellEditor(new ButtonEditor("✘ Borrar", BTN_DELETE_BG, () -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                clienteService.findById(id).ifPresent(c -> abrirFormulario(FormMode.BAJA, c));
            }
        }));

        table.setDefaultRenderer(String.class, new AlternatingRowRenderer());

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBackground(BG_DARK);
        scroll.getViewport().setBackground(BG_DARK);
        scroll.setBorder(new EmptyBorder(12, 16, 0, 16));
        scroll.getVerticalScrollBar().setBackground(BG_PANEL);
        return scroll;
    }

    private JPanel buildFooter() {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        footer.setBackground(BG_PANEL);
        footer.setBorder(new CompoundBorder(
            new MatteBorder(2, 0, 0, 0, ACCENT_SOFT),
            new EmptyBorder(8, 20, 8, 20)
        ));
        JLabel info = new JLabel("(o ^ - ^ o)  Sistema de Gestión de Clientes");
        info.setFont(FONT_SMALL);
        info.setForeground(TEXT_DIM);
        footer.add(info);
        return footer;
    }

    private enum FormMode { ALTA, MODIFICAR, BAJA }

    private void abrirFormulario(FormMode mode, Cliente cliente) {
        JDialog dialog = new JDialog(this, true);
        dialog.setBackground(BG_PANEL);
        dialog.getContentPane().setBackground(BG_PANEL);
        dialog.setLayout(new BorderLayout(0, 0));
        dialog.setResizable(false);
        dialog.setSize(420, 340);
        dialog.setLocationRelativeTo(this);

        String tituloStr;
        String btnTexto;
        Color  btnColor;
        switch (mode) {
            case ALTA     -> { tituloStr = "+ Dar de Alta";         btnTexto = "Crear Cliente";    btnColor = SUCCESS_MINT; }
            case MODIFICAR-> { tituloStr = "✎ Modificar Cliente";   btnTexto = "Guardar Cambios";  btnColor = BTN_EDIT_BG; }
            default       -> { tituloStr = "✘ Eliminar Cliente";    btnTexto = "Confirmar Baja";   btnColor = BTN_DELETE_BG; }
        }
        dialog.setTitle(tituloStr);

        JPanel pTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pTitulo.setBackground(BG_CARD);
        pTitulo.setBorder(new CompoundBorder(
            new MatteBorder(0, 0, 2, 0, ACCENT_SKY),
            new EmptyBorder(12, 20, 12, 20)
        ));
        JLabel lbTitulo = new JLabel(tituloStr);
        lbTitulo.setFont(FONT_HEADER);
        lbTitulo.setForeground(TEXT_DARK);
        pTitulo.add(lbTitulo);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(BG_PANEL);
        form.setBorder(new EmptyBorder(20, 24, 10, 24));

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets  = new Insets(6, 4, 6, 4);
        gc.fill    = GridBagConstraints.HORIZONTAL;
        gc.anchor  = GridBagConstraints.WEST;

        boolean editable = (mode != FormMode.BAJA);

        JTextField tfRazon     = buildFormField(form, gc, 0, "Razón Social",      cliente != null ? cliente.getRazonSocial()     : "", editable);
        JTextField tfComercial = buildFormField(form, gc, 1, "Nombre Comercial",   cliente != null ? cliente.getNombreComercial() : "", editable);
        JTextField tfCredito   = buildFormField(form, gc, 2, "Límite Crédito",  cliente != null ? String.format("%.2f", cliente.getLimiteCredito()) : "", editable);

        if (!editable) {
            tfRazon.setForeground(TEXT_DIM);
            tfComercial.setForeground(TEXT_DIM);
            tfCredito.setForeground(TEXT_DIM);
        }

        JPanel pBtns = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        pBtns.setBackground(BG_PANEL);
        pBtns.setBorder(new EmptyBorder(4, 20, 16, 20));

        JButton btnCancelar = buildIconButton("Cancelar", TEXT_DARK, BG_CARD);
        btnCancelar.addActionListener(e -> dialog.dispose());

        JButton btnConfirmar = buildIconButton(btnTexto, TEXT_DARK, btnColor);
        btnConfirmar.addActionListener(e -> {
            boolean ok = false;
            try {
                switch (mode) {
                    case ALTA -> {
                        Cliente nuevo = new Cliente();
                        nuevo.setRazonSocial(tfRazon.getText().trim());
                        nuevo.setNombreComercial(tfComercial.getText().trim());
                        nuevo.setLimiteCredito(Double.parseDouble(tfCredito.getText().replace(",", ".")));
                        clienteService.create(nuevo);
                        ok = true;
                    }
                    case MODIFICAR -> {
                        cliente.setRazonSocial(tfRazon.getText().trim());
                        cliente.setNombreComercial(tfComercial.getText().trim());
                        cliente.setLimiteCredito(Double.parseDouble(tfCredito.getText().replace(",", ".")));
                        clienteService.update(cliente);
                        ok = true;
                    }
                    case BAJA -> {
                        clienteService.deleteById(cliente.getId());
                        ok = true;
                    }
                }
            } catch (NumberFormatException ex) {
                mostrarError(dialog, "El límite de crédito debe ser un número válido.");
                return;
            } catch (Exception ex) {
                mostrarError(dialog, "Error: " + ex.getMessage());
                return;
            }
            if (ok) {
                dialog.dispose();
                refrescarTabla(clienteService.findAll());
                mostrarExito(switch (mode) {
                    case ALTA      -> "¡Cliente creado correctamente!";
                    case MODIFICAR -> "¡Datos actualizados!";
                    case BAJA      -> "¡Cliente eliminado!";
                });
            }
        });

        pBtns.add(btnCancelar);
        pBtns.add(btnConfirmar);

        dialog.add(pTitulo, BorderLayout.NORTH);
        dialog.add(form,    BorderLayout.CENTER);
        dialog.add(pBtns,   BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private JTextField buildFormField(JPanel form, GridBagConstraints gc,
                                      int row, String label, String value, boolean editable) {
        gc.gridy = row;

        gc.gridx = 0; gc.weightx = 0.0;
        JLabel lbl = new JLabel(label);
        lbl.setFont(FONT_BODY);
        lbl.setForeground(TEXT_DARK);
        form.add(lbl, gc);

        gc.gridx = 1; gc.weightx = 1.0;
        JTextField tf = new JTextField(value);
        tf.setEditable(editable);
        tf.setBackground(editable ? BG_CARD : BG_DARK);
        tf.setForeground(TEXT_DARK);
        tf.setCaretColor(TEXT_DARK);
        tf.setFont(FONT_BODY);
        tf.setBorder(new CompoundBorder(
            new LineBorder(editable ? ACCENT_SKY : BG_CARD, 1, true),
            new EmptyBorder(4, 8, 4, 8)
        ));
        form.add(tf, gc);
        return tf;
    }

    private void onSearchTypeChanged() {
        int sel = searchTypeCombo.getSelectedIndex();
        searchField.setVisible(sel != 0);
        searchField.setText("");
        if (sel == 0) refrescarTabla(clienteService.findAll());
        searchTypeCombo.getParent().revalidate();
        searchTypeCombo.getParent().repaint();
    }

    private void ejecutarBusqueda() {
        int sel = searchTypeCombo.getSelectedIndex();
        if (sel == 0) {
            refrescarTabla(clienteService.findAll());
        } else if (sel == 1) {
            String txt = searchField.getText().trim();
            if (txt.isEmpty()) { refrescarTabla(clienteService.findAll()); return; }
            try {
                int id = Integer.parseInt(txt);
                ArrayList<Cliente> res = new ArrayList<>();
                clienteService.findById(id).ifPresent(res::add);
                refrescarTabla(res);
                if (res.isEmpty()) mostrarAviso("No se encontró ningún cliente con ID " + id);
            } catch (NumberFormatException ex) {
                mostrarError(this, "El ID debe ser un número entero.");
            }
        } else {
            String txt = searchField.getText().trim();
            if (txt.isEmpty()) { refrescarTabla(clienteService.findAll()); return; }
            ArrayList<Cliente> res = clienteService.findByRazonSocial(txt);
            refrescarTabla(res);
            if (res.isEmpty()) mostrarAviso("Sin coincidencias para \"" + txt + "\"");
        }
    }

    private void refrescarTabla(ArrayList<Cliente> clientes) {
        tableModel.setRowCount(0);
        for (Cliente c : clientes) {
            tableModel.addRow(new Object[]{
                c.getId(),
                c.getRazonSocial(),
                c.getNombreComercial(),
                String.format("%.2f €", c.getLimiteCredito()),
                "✎ Editar",
                "✘ Borrar"
            });
        }
    }

    private JButton buildIconButton(String text, Color fg, Color bg) {
        JButton btn = new JButton(text) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed() ? bg.darker() :
                            getModel().isRollover() ? bg.brighter() : bg);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(FONT_BTN);
        btn.setForeground(fg);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(new EmptyBorder(7, 14, 7, 14));
        return btn;
    }

    private void styleTextField(JTextField tf) {
        tf.setBackground(BG_CARD);
        tf.setForeground(TEXT_DARK);
        tf.setCaretColor(TEXT_DARK);
        tf.setFont(FONT_BODY);
        tf.setBorder(new CompoundBorder(
            new LineBorder(ACCENT_SKY, 1, true),
            new EmptyBorder(4, 8, 4, 8)
        ));
    }

    private void styleCombo(JComboBox<String> cb) {
        cb.setBackground(BG_CARD);
        cb.setForeground(TEXT_DARK);
        cb.setFont(FONT_BODY);
        cb.setBorder(BorderFactory.createLineBorder(ACCENT_SKY));
        cb.setFocusable(false);
    }

    private void mostrarAviso(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Información",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarExito(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Éxito",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    private class ButtonRenderer implements TableCellRenderer {
        private final JButton btn;
        ButtonRenderer(String text, Color bg) {
            btn = buildIconButton(text, TEXT_DARK, bg);
            btn.setOpaque(false);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            return btn;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        private final JButton btn;
        private Runnable currentAction;

        ButtonEditor(String text, Color bg, Runnable action) {
            super(new JCheckBox());
            this.currentAction = action;
            setClickCountToStart(1);

            btn = buildIconButton(text, TEXT_DARK, bg);
            btn.addActionListener(e -> {
                fireEditingStopped();
                if (currentAction != null) {
                    currentAction.run();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int col) {
            return btn;
        }

        @Override
        public Object getCellEditorValue() {
            return btn.getText();
        }

        @Override
        public boolean isCellEditable(java.util.EventObject e) {
            return true;
        }
    }

    private class AlternatingRowRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            setFont(FONT_CELL);
            setBorder(new EmptyBorder(0, 10, 0, 10));

            if (isSelected) {
                setBackground(ACCENT_SOFT);
                setForeground(TEXT_DARK);
            } else {
                setBackground(row % 2 == 0 ? BG_PANEL : ROW_ALT);
                setForeground(TEXT_DARK);
            }

            if (col == 3) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                setFont(FONT_CELL.deriveFont(Font.BOLD));
            } else if (col == 0) {
                setHorizontalAlignment(SwingConstants.CENTER);
                if (!isSelected) setForeground(ACCENT_PINK);
            } else {
                setHorizontalAlignment(SwingConstants.LEFT);
            }
            return this;
        }
    }

    public void iniciar() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}