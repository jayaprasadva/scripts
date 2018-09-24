#!/usr/bin/env perl

use strict;
use warnings;
use autodie;
use English qw( -no_match_vars );
use utf8;
use 5.010;

use version; our $VERSION = qv('0.2.0');

my $name      = shift();
my $operation = shift();

if (defined $name) {
    if ( $name !~ /\./xms ) {
        $name .= '.service';
    }
    $operation //= 'status';
    exec('systemctl', $operation, $name);
} else {
    $operation //= 'list-units';
    exec('systemctl', $operation);
}
