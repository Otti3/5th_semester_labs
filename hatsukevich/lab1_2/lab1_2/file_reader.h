#ifndef FILE_READER_H
#define FILE_READER_H
#include <QWidget>
#include <QGridLayout>
#include <QApplication>
#include <QTextEdit>
#include <QPushButton>
#include <QFileDialog>
#include <QObject>


class File_reader : public QWidget
{
    Q_OBJECT
public:
    File_reader(QWidget *parent = 0);

private:
    QGridLayout *grid_layout;
    QTextEdit *text_edit;
    QPushButton *button;


private slots:
    int openFile();

};

#endif // FILE_READER_H
