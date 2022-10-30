#include <QGridLayout>
#include <QApplication>
#include <QTextEdit>
#include <QPushButton>
#include <QFileDialog>
#include <QObject>
#include "file_reader.h"


int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    File_reader widget;

   // w.resize(400,400);
    widget.show();
    return a.exec();
}


